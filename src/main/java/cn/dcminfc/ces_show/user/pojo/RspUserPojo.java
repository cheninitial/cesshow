package cn.dcminfc.ces_show.user.pojo;

public class RspUserPojo {
    private String openId;

    public RspUserPojo() {
    }

    public RspUserPojo(String openId) {
        this.openId = openId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
