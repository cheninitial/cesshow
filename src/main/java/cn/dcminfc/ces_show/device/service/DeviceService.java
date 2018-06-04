package cn.dcminfc.ces_show.device.service;

public interface DeviceService {
    Boolean isCanUse(String deviceId);

    Boolean checkCMD(String deviceId,String cmd);

    Boolean isHas(String deviceId);

}
