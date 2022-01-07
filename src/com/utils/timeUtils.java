package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class timeUtils {

    public String addAndSubtractDaysByGetTime(Date dateTime/*待处理的日期*/, int n/*加减天数*/) {
        //日期格式
        SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println(dd.format(new Date(dateTime.getTime() + n * 24 * 60 * 60 * 1000L)));
        //注意这里一定要转换成Long类型，要不n超过25时会出现范围溢出，从而得不到想要的日期值

        return dd.format(new Date(dateTime.getTime() + n * 24 * 60 * 60 * 1000L));
    }

    public String getTime(Date now) {
        SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
        return dd.format(now);
    }

    public long timeDifference(String start_time, String return_time) {
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long between = 0;
        try {
            Date begin = dfs.parse(start_time);
            Date end = dfs.parse(return_time);
            between = (end.getTime() - begin.getTime());// 得到两者的毫秒数
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return between / (24 * 60 * 60 * 1000);
    }
}
