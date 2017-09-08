package com.sh.sculuo.libluo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by luoxiaocheng on 2017/6/20.
 */

public class TimeUtil {
    public static String liveShow(long time) {
        String show;
        long s = time / 1000;
        long ms = time % 1000;
        if (s <= 0)
            return "00:00." + ms;
        long m = s / 60;
        s = s % 60;
        if (m <= 0)
            return (s < 10 ? "00:00:0" : "00:00:") + s;
        long h = m / 60;
        m = m % 60;
        if (h <= 0)
            return ((m < 10 ? "00:0" : "00:") + m) + ((s < 10 ? ":0" : ":") + s);
        return ((h < 10 ? "0" : "") + h) + ((m < 10 ? ":0" : ":") + m) + ((s < 10 ? ":0" : ":") + s);
    }

    public static String timeNow(String pattern) {
        return long2String(System.currentTimeMillis(), pattern);
    }

    public static String long2String(long now, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(now);
    }

    public static long string2Long(String now, String regular) {
        SimpleDateFormat format = new SimpleDateFormat(regular);
        try {
            Date parse = format.parse(now);
            return parse.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
