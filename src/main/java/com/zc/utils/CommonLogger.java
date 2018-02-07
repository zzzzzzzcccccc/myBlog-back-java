package com.zc.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
* 日志封装
* */
public class CommonLogger {

    private static final Logger logger = LogManager.getLogger();

    public static Logger getLogger() {
        return logger;
    }

    public static void info(String msg) {
        logger.info(msg);
    }

    public static void debug(String msg) {
        logger.debug(msg);
    }

    public static void warn(String msg) {
        logger.warn(msg);
    }

    public static void error(String msg) {
        logger.error(msg);
    }

    public static void trace(String msg) {
        logger.trace(msg);
    }
}
