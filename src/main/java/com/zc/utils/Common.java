package com.zc.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Common {
    /*
    * 获取每天的0点
    * */
    public static String getNowDate() {
        Date nowDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(nowDate);
    }
}
