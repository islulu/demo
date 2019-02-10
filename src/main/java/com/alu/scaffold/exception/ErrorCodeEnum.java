package com.alu.scaffold.exception;

public enum ErrorCodeEnum {
    SUCCESS(0, "成功"),
    NO_LOGIN(1001, "未登录或登录超时，请重新登录"),
    LOGIN_FAILURE(1002, "登录用户名或密码错误"),
    UPDATE_USER_NOT_EXIST(1003, "要更新的用户信息不存在"),
    PHONE_IS_EMPTY(1004, "注册时用户手机号不能为空"),
    PASSWORD_IS_EMPTY(1005, "注册时密码不能为空"),
    NICKNAME_SEX_IS_EMPTY(1006, "注册时昵称、性别不能为空"),
    USER_NOT_EXIST(1007, "要查询的用户信息不存在"),
    USER_ID_IS_NULL(1008, "用户ID不能空"),
    TOKEN_IS_NULL(1009, "Token不能为空"),
    PHONE_NO_FORMATE_ERROR(1010, "手机号格式错误"),
    SEND_CODE_ERROR(1011, "发送验证码错误"),
    CODE_ERROR(1012, "验证码错误"),
    USER_LOGIN_IN_OTHER_DEVICE(1013, "用户已在其他设备登录"),
    TOKEN_UNABLE(1014, "token无效"),
    CODE_IS_EMPTY(1015, "验证码不能为空"),
    USER_NO_PERMIT(1016, "该用户无此权限"),
    USER_EXIST(1017, "该用户已存在"),
    MISSING_REQUEST_PARAMETERS(9996, "缺少必填参数"),
    NULL_POINT_ERROR(9997, "后台空指针"),
    DB_ERROR(9998, "数据库异常"),
    OTHER_ERROR(9999, "其它系统异常");

    private int code;
    private String desc;// 错误信息

    ErrorCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
