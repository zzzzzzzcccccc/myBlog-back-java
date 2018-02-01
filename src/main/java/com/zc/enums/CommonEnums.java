package com.zc.enums;

/*
* 公共http请求枚举
* */
public enum CommonEnums {
    SUCCESS(200, "success"),
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
