package cn.dcminfc.ces.util;


import cn.dcminfc.ces.util.pojo.Result;

public class ConstantResult {
    final public static Result SUCCESS = new Result("00", "SUCCESS");
    final public static Result HTTP_BODY_ERROR = new Result("E0101", "请求体错误");
    final public static Result CMD_LIMITED = new Result("E0201", "用户受限制");
    final public static Result MYSQL_ERROR = new Result("E0501", "用户受限制");

}
