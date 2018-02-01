package com.zc.utils;

import com.zc.enums.CommonEnums;

/*
* 公共http返回
* */
public class CommonResult<T> {

    private Integer code;

    private String msg;

    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static CommonResult success(Object object) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(CommonEnums.SUCCESS.getCode());
        commonResult.setMsg(CommonEnums.SUCCESS.getMsg());
        commonResult.setData(object);

        return commonResult;
    }

    public static CommonResult error(Integer code, String msg) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(code);
        commonResult.setMsg(msg);
        commonResult.setData("");

        return commonResult;
    }

    public static CommonResult isNull(Object object) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(CommonEnums.NULL.getCode());
        commonResult.setMsg(CommonEnums.NULL.getMsg());
        commonResult.setData(object);

        return commonResult;
    }
}
