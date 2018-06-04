package cn.dcminfc.ces_show.user.domain;

import com.hand.hap.cloud.mybatis.annotation.ModifyAudit;
import com.hand.hap.cloud.mybatis.annotation.VersionAudit;
import com.hand.hap.cloud.mybatis.domain.AuditDomain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@ModifyAudit
@VersionAudit
@Table(name = "c_user")
public class UserDomain extends AuditDomain {
    @Id
    @GeneratedValue
    private Long id;

    private String openId;
    private String name;
    private String picUrl;
    private String userUnid;
    private int flag;
    private String tmpCode;

    public UserDomain() {
    }

    public UserDomain(String openId) {
        this.openId = openId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getUserUnid() {
        return userUnid;
    }

    public void setUserUnid(String userUnid) {
        this.userUnid = userUnid;
    }

    public String getTmpCode() {
        return tmpCode;
    }

    public void setTmpCode(String tmpCode) {
        this.tmpCode = tmpCode;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
