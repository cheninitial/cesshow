package cn.dcminfc.ces.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public final static int TYPE_YMDHMS = 0;

    public static String getTime(int type){
        switch (type){
            case TYPE_YMDHMS:
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
                return date;
            default:
                return null;
        }
    }
}
