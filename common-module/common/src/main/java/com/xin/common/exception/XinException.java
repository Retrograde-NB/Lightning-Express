package com.xin.common.exception;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author Retrograde-LX
 * @Date 2024/03/08 下午 12:24
 * @Version 1.0
 * @Remark 又是程序猿秃头的一天
 */
public class XinException extends RuntimeException {
    @ApiModelProperty(value = "状态码")
    private Integer code;
    @ApiModelProperty(value = "信息")
    private String msg;

    public XinException(){

    }
    public XinException(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public XinException(String message, Throwable cause) {
        super(message, cause);
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}