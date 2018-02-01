package com.zc.utils;

import com.zc.enums.CommonEnums;

/*
* 自定义异常抛出
* */
public class CommonException extends RuntimeException {

    private Integer code;

    public CommonException(CommonEnums commonEnums) {

        super(commonEnums.getMsg());
        this.code = commonEnums.getCode();
    }

    public Integer getCode() {

        return code;
    }

    public void setCode(Integer code) {

        this.code = code;
    }
}
