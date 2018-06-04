package cn.dcminfc.ces_show.utils;

public class StringUtils {
    /**
    *@Author: yuanliang.chen
    *@Date: 2018/5/29 18:40
    *@Description:
     *  判断字符串 是为null或者为“”
    */
    public static Boolean isEmpty(String str) {
        return "".equals(str) || (str == null);
    }
}
