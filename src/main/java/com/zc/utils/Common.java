package com.zc.utils;

import java.text.SimpleDateFormat;
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

    /*
    * 按特定的符号分割字符串 数组
    * @params string 被分割的字符串
    * @params sign 符号
    * */
    public static String[] getSplitToArray(String string, String sign) {

        return string.split(sign);
    }
}
