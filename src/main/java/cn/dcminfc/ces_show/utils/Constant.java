package cn.dcminfc.ces_show.utils;

public class Constant {
    public static String APPID = "wx88beddabf7d79515";
    public static String AppSecret = "f7c3f75fe44592df061fcfd46c5020ed";


    //错误信息
    public static Result RESULT_00 = new Result("00", "success");
    public static Result RESULT_E0101 = new Result("E0101", "user数据库操作错误");
    public static Result RESULT_E0102 = new Result("E0102", "查询OpenID错误");
    public static Result RESULT_E0103 = new Result("E0103", "设备目前不可用");
    public static Result RESULT_E0201 = new Result("E0201", "cmd数据库插入错误");
    public static Result RESULT_E0202 = new Result("E0202", "用户没有权限");
    public static Result RESULT_E0203 = new Result("E0203", "设备状态不符合要求");

    public static Result RESULT_E0301 = new Result("E0301", "no this device");
    public static Result RESULT_E0302 = new Result("E0302", "no new cmd");


    public static Result RESULT_EFF01 = new Result("EFF01", "数据体不符合要求");


    public static String URL_WXUSER = "https://api.weixin.qq.com/sns/jscode2session";


    public static String WX_OPENID_HTTP_KEY1 = "session_key";
    public static String WX_OPENID_HTTP_KEY2 = "openid";
    public static String WX_OPENID_HTTP_KEY3 = "errcode";
    public static String WX_OPENID_HTTP_KEY4 = "errmsg";

    public static int DEVICE_STATUS_ERROR = -1;
    public static int DEVICE_STATUS_IDLE = 0;
    public static int DEVICE_STATUS_OPEN = 1;
    public static int DEVICE_STATUS_USED = 2;

    public static int USER_FLAG_LIMITED = 0;
    public static int USER_FLAG_CANUSE = 1;

    public static int CMD_FLAG_WAIT = 0;
    public static int CMD_FLAG_DEALED = 1;


    public static Long USER_DEFAULT_FAILTIME = 300000L;
    public static Long CMD_DEFULT_FAILTIME = 120000L;


    //程序测试打桩码
    public static int stub = 0;

    public static String DEVICE_DEFAULT = "ces_device_1";

    public static String CMD_OPENDOOR = "openDoor";
    public static String CMD_START = "start";


}
