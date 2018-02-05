package com.zc.handle;

import com.zc.aspect.httpAspect;
import com.zc.utils.CommonResult;
import com.zc.utils.CommonException;
import com.zc.enums.CommonEnums;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*
* 异常捕获
* */
@ControllerAdvice
public class ExceptionHandle {

    private final Logger logger = LogManager.getLogger(httpAspect.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult allExceptionHandle(Exception e) {
        if(e instanceof CommonException) {
            CommonException commonException = (CommonException) e;

            return CommonResult.error(commonException.getCode(), commonException.getMessage());
        } else {
            // logger.info("【系统异常】:{}", e.toString());
            logger.error("【系统异常】:" + e.toString());

            return CommonResult.error(CommonEnums.ERROR.getCode(), e.toString());
        }
    }
}
