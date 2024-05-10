package com.xin.log.aspect;

import com.alibaba.fastjson2.JSON;
import com.xin.common.constant.RedisConstants;
import com.xin.common.domain.system.dto.SysOperationLogDTO;
import com.xin.common.redis.service.RedisService;
import com.xin.common.utils.*;
import com.xin.log.annotation.Log;
import com.xin.log.enums.OperationStatus;
import com.xin.log.filter.PropertyPreExcludeFilter;
import com.xin.log.service.LogService;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/19 下午 8:22
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
@Aspect
@Component
public class LogAspect {
    private final LogService logService;

    private final RedisService redisService;

    public LogAspect(LogService logService, RedisService redisService) {
        this.logService = logService;
        this.redisService = redisService;
    }

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
    /**
     * 排除敏感属性字段
     */
    public static final String[] EXCLUDE_PROPERTIES = {"password", "oldPassword", "newPassword", "confirmPassword"};
    /**
     * 计算操作消耗时间
     */
    private static final ThreadLocal<Long> TIME_THREAD_LOCAL = new NamedThreadLocal<Long>("Cost Time");

    /**
     * 处理请求前执行
     */
    @Before(value = "@annotation(controllerLog)")
    public void boBefore(JoinPoint joinPoint, Log controllerLog) {
        TIME_THREAD_LOCAL.set(System.currentTimeMillis());
    }

    /**
     * 处理完请求后执行
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "@annotation(controllerLog)", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Log controllerLog, Object jsonResult) {
        handleLog(joinPoint, controllerLog, null, jsonResult);
    }

    /**
     * 拦截异常操作
     * @param joinPoint 切点
     * @param e         异常
     */
    @AfterThrowing(value = "@annotation(controllerLog)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Log controllerLog, Exception e) {
        handleLog(joinPoint, controllerLog, e, null);
    }

    protected void handleLog(final JoinPoint joinPoint, Log controllerLog, final Exception e, Object jsonResult) {
        try {
            SysOperationLogDTO sysOperationLogDTO = ReflectionUtils.newInstance(SysOperationLogDTO.class);
            sysOperationLogDTO.setStatus(OperationStatus.SUCCESS.ordinal());
            // 请求的地址
            String ip = IpUtils.getIpAddr();
            sysOperationLogDTO.setOperationIp(ip);
            sysOperationLogDTO.setOperationUrl(StringUtils.substring(ServletUtils.getRequest().getRequestURI(), 0, 255));
            // TODO 获取后台用户名(暂时使用) Long id = JwtUtils.getId();
            String token = redisService.getCacheObject(RedisConstants.TOKEN).toString();
            String userName = JwtUtils.getUserName(token);
            if (StringUtils.isNotBlank(userName)) {
                sysOperationLogDTO.setOperationName(userName);
            }

            if (e != null) {
                sysOperationLogDTO.setStatus(OperationStatus.FAIL.ordinal());
                sysOperationLogDTO.setErrorMsg(StringUtils.substring(e.getMessage(), 0, 2000));
            }
            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            sysOperationLogDTO.setMethod(className + "." + methodName + "()");
            // 设置请求方式
            sysOperationLogDTO.setRequestMethod(ServletUtils.getRequest().getMethod());
            // 处理设置注解上的参数
            getControllerMethodDescription(joinPoint, controllerLog, sysOperationLogDTO, jsonResult);
            // 设置消耗时间
            sysOperationLogDTO.setCostTime(System.currentTimeMillis() - TIME_THREAD_LOCAL.get());
            // 保存数据库
            logService.saveOperationLog(sysOperationLogDTO);
        } catch (Exception exp) {
            // 记录本地异常日志
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        } finally {
            TIME_THREAD_LOCAL.remove();
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     * @param log     日志
     * @param sysOperationLogDTO 操作日志
     * @throws Exception 异常
     */
    public void getControllerMethodDescription(JoinPoint joinPoint, Log log, SysOperationLogDTO sysOperationLogDTO, Object jsonResult) throws Exception {
        // 设置action动作
        sysOperationLogDTO.setBusinessType(log.operationType().ordinal());
        // 设置标题
        sysOperationLogDTO.setTitle(log.title());
        // 设置操作人类别
        sysOperationLogDTO.setOperatorType(log.operatorType().ordinal());
        // 是否需要保存request，参数和值
        if (log.isSaveRequestData()) {
            // 获取参数的信息，传入到数据库中。
            setRequestValue(joinPoint, sysOperationLogDTO, log.excludeParamNames());
        }
        // 是否需要保存response，参数和值
        if (log.isSaveResponseData() && StringUtils.isNotNull(jsonResult)) {
            sysOperationLogDTO.setJsonResult(StringUtils.substring(JSON.toJSONString(jsonResult), 0, 2000));
        }
    }

    /**
     * 获取请求的参数，放到log中
     * @param sysOperationLogDTO 操作日志
     * @throws Exception 异常
     */
    private void setRequestValue(JoinPoint joinPoint, SysOperationLogDTO sysOperationLogDTO, String[] excludeParamNames) throws Exception {
        String requestMethod = sysOperationLogDTO.getRequestMethod();
        Map<?, ?> paramsMap = ServletUtils.getParamMap(ServletUtils.getRequest());
        if (StringUtils.isEmpty(paramsMap)
                && (HttpMethod.PUT.name().equals(requestMethod) || HttpMethod.POST.name().equals(requestMethod))) {
            String params = argsArrayToString(joinPoint.getArgs(), excludeParamNames);
            sysOperationLogDTO.setOperationParam(StringUtils.substring(params, 0, 2000));
        } else {
            sysOperationLogDTO.setOperationParam(StringUtils.substring(JSON.toJSONString(paramsMap, excludePropertyPreFilter(excludeParamNames)), 0, 2000));
        }
    }
    /**
     * 参数拼装
     */
    private String argsArrayToString(Object[] paramsArray, String[] excludeParamNames) {
        String params = "";
        if (paramsArray != null && paramsArray.length > 0) {
            for (Object o : paramsArray) {
                if (StringUtils.isNotNull(o) && !isFilterObject(o)) {
                    try {
                        String jsonObj = JSON.toJSONString(o, excludePropertyPreFilter(excludeParamNames));
                        params += jsonObj.toString() + " ";
                    } catch (Exception e) {
                    }
                }
            }
        }
        return params.trim();
    }

    /**
     * 忽略敏感属性
     */
    public PropertyPreExcludeFilter excludePropertyPreFilter(String[] excludeParamNames) {
        return new PropertyPreExcludeFilter().addExcludes(ArrayUtils.addAll(EXCLUDE_PROPERTIES, excludeParamNames));
    }

    /**
     * 判断是否需要过滤的对象。
     * @param o 对象信息。
     * @return 如果是需要过滤的对象，则返回true；否则返回false。
     */
    @SuppressWarnings("rawtypes")
    public boolean isFilterObject(final Object o) {
        Class<?> clazz = o.getClass();
        if (clazz.isArray()) {
            return clazz.getComponentType().isAssignableFrom(MultipartFile.class);
        } else if (Collection.class.isAssignableFrom(clazz)) {
            Collection collection = (Collection) o;
            for (Object value : collection) {
                return value instanceof MultipartFile;
            }
        } else if (Map.class.isAssignableFrom(clazz)) {
            Map map = (Map) o;
            for (Object value : map.entrySet()) {
                Map.Entry entry = (Map.Entry) value;
                return entry.getValue() instanceof MultipartFile;
            }
        }
        return o instanceof MultipartFile || o instanceof HttpServletRequest || o instanceof HttpServletResponse
                || o instanceof BindingResult;
    }
}
