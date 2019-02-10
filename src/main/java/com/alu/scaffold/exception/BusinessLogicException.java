package com.alu.scaffold.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessLogicException extends RuntimeException {
    private static final long serialVersionUID = -1658132880061605029L;

    private ErrorCodeEnum errorCodeEnum;

    private Object extra;

    public BusinessLogicException(ErrorCodeEnum errorCodeEnum) {
        this.errorCodeEnum = errorCodeEnum;
    }

    public BusinessLogicException(ErrorCodeEnum errorCodeEnum, Object extra) {
        this.errorCodeEnum = errorCodeEnum;
        this.extra = extra;
    }

}