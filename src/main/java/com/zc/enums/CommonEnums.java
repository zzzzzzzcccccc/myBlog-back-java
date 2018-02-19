package com.zc.enums;

/*
* 公共http请求枚举
* */
public enum CommonEnums {
    SUCCESS(200, "success"),
    USER_NAME_INFO(301, "账号已存在"),
    LOGIN_ERROR(302, "账号或密码错误"),
    LOGIN_VISIBLE(303, "该账号已被禁用"),
    ROLE_NAME_INFO(304, "角色名称已存在"),
    NULL(404, "未查询到数据"),
    ERROR(500, "未知错误"),
    PARAMS(501, "请求参数错误"),
    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    CommonEnums(Integer code, String msg) {

        this.code = code;
        this.msg = msg;
    }
}
