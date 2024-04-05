package com.xin.common.utils;

import org.springframework.util.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author Retrograde-LX
 * @Date 2024/04/05 上午 10:09
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class ReflectionUtils {
    /**
     * 使用默认构造器创建对象
     *
     * @param className 完整类名
     * @param <T>       泛型对象
     * @return 创建的对象
     */
    public static <T> T newInstance(String className) {
        try {
            @SuppressWarnings("unchecked")
            Class<T> clazz = (Class<T>) Class.forName(className);
            return newInstance(clazz);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("类未找到", e);
        }
    }

    /**
     * 使用默认构造器创建对象
     *
     * @param clazz 类对象
     * @param <T>   泛型对象
     * @return 创建的对象
     */
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("创建对象失败", e);
        }
    }

    /**
     * 使用带参数的构造器创建对象
     *
     * @param className 完整类名
     * @param params    构造器参数
     * @param <T>       泛型对象
     * @return 创建的对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstanceWithConstructor(String className, Object... params) {
        if (StringUtils.isEmpty(className) || params == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        try {
            Class<?>[] paramTypes = new Class[params.length];
            for (int i = 0; i < params.length; i++) {
                paramTypes[i] = params[i].getClass();
            }
            Class<T> clazz = (Class<T>) Class.forName(className);
            Constructor<T> constructor = clazz.getConstructor(paramTypes);
            return constructor.newInstance(params);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("创建对象失败", e);
        }
    }
}
