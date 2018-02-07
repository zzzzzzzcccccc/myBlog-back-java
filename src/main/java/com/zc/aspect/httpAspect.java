package com.zc.aspect;

import com.zc.utils.CommonLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/*
* http捕获
* */
@Aspect
@Component
public class httpAspect {

    @Pointcut("execution(public * com.zc.controller.*.*(..))")
    public void log() {
    }

    /*
    * 请求之前
    * */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // url
        // logger.info("请求url:{}", request.getRequestURL());
        CommonLogger.info("请求url:" + request.getRequestURL());

        // method
        // logger.info("请求方式:{}", request.getMethod());
        CommonLogger.info("请求方式:" + request.getMethod());

        // ip
        // logger.info("请求ip:{}", request.getRemoteAddr());
        CommonLogger.info("请求ip:" + request.getRemoteAddr());

        // 类方法
        // logger.info("调用方法:{}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        CommonLogger.info("调用方法:" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        // params
        // logger.info("参数:{}", joinPoint.getArgs());
        CommonLogger.info("参数:" + joinPoint.getArgs());
    }

    /*
    *请求之后
    * */
    @After("log()")
    public void doAfter() {
        // logger.info("http请求完毕={}", new Date().getTime());
        CommonLogger.info("http请求完毕:" + new Date().getTime());
    }

    /*
    * 返回内容
    * */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
    }
}
