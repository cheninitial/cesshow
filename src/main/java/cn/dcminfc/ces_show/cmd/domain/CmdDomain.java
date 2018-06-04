package cn.dcminfc.ces_show.cmd.domain;

import com.hand.hap.cloud.mybatis.annotation.ModifyAudit;
import com.hand.hap.cloud.mybatis.annotation.VersionAudit;
import com.hand.hap.cloud.mybatis.domain.AuditDomain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@ModifyAudit
@VersionAudit
@Table(name = "c_cmd")
public class CmdDomain extends AuditDomain {
    @Id
    @GeneratedValue
    private Long id;

    private String openId;

    private String cmd;
    private String deviceId;
    private int flag;

    public CmdDomain() {
    }

    public CmdDomain(String deviceId, int flag) {
        this.deviceId = deviceId;
        this.flag = flag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;

    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
