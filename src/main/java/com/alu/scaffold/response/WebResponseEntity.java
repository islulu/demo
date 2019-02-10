package com.alu.scaffold.response;

import com.alu.scaffold.exception.ErrorCodeEnum;
import lombok.Data;

import java.io.Serializable;


@Data
public class WebResponseEntity<T> implements Serializable {
    private static final long serialVersionUID = 5600732461682124950L;

    private int errorCode;

    private String errorMessage;

    private T data;

    public WebResponseEntity() {

    }

    public WebResponseEntity(T data) {
        this.data = data;
    }

    public WebResponseEntity(ErrorCodeEnum errorCodeEnum) {
        this.errorCode = errorCodeEnum.getCode();
        this.errorMessage = errorCodeEnum.getDesc();
        this.data = null;
    }

    public WebResponseEntity(ErrorCodeEnum errorCodeEnum, T data) {
        this(errorCodeEnum);
        this.data = data;
    }

    public WebResponseEntity(int errorCode, String errorMessage, T data) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public static <T> WebResponseEntity<T> ok(T data) {
        WebResponseEntity webResponseEntity = new WebResponseEntity(data);
        return webResponseEntity;
    }

}
