package cn.dcminfc.ces_show.device.domain;

import com.hand.hap.cloud.mybatis.annotation.ModifyAudit;
import com.hand.hap.cloud.mybatis.annotation.VersionAudit;
import com.hand.hap.cloud.mybatis.domain.AuditDomain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@ModifyAudit
@VersionAudit
@Table(name = "c_device")
public class DeviceDomain extends AuditDomain {
    @Id
    @GeneratedValue
    private Long id;

    private String deviceId;
    private int status;
    private String lastUser;

    public DeviceDomain() {
    }

    public DeviceDomain(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLastUser() {
        return lastUser;
    }

    public void setLastUser(String lastUser) {
        this.lastUser = lastUser;
    }
}
