package cn.dcminfc.ces_show.utils;

import java.util.Date;

public class TimeUtils {
    public static Long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static Long getDCurrentTime(Date date) {
        return getCurrentTime() - date.getTime();
    }
}
