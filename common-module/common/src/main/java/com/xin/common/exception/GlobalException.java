package com.xin.common.exception;

import com.xin.common.result.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/08 下午 12:14
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 * 全局异常
 */
@ControllerAdvice
public class GlobalException extends RuntimeException{
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult error(Exception e) {
        e.printStackTrace();
        return ResponseResult.fail();
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ResponseResult error(ArithmeticException e) {
        e.printStackTrace();
        return ResponseResult.fail("执行了自定义异常");
    }

    @ExceptionHandler(XinException.class)
    @ResponseBody
    public ResponseResult error(XinException e) {
        e.printStackTrace();
        return ResponseResult.fail(e.getCode(), e.getMsg());
    }
}
