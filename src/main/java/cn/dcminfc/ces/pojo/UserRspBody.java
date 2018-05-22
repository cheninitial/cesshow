package cn.dcminfc.ces.pojo;

import cn.dcminfc.ces.util.pojo.Result;

public class UserRspBody {
    private String code;
    private String msg;

    public UserRspBody() {
    }

    public UserRspBody(Result result) {
        this.code = result.getCode();
        this.msg = result.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
