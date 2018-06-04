package cn.dcminfc.ces_show.device.service.serviceImpl;

import cn.dcminfc.ces_show.device.domain.DeviceDomain;
import cn.dcminfc.ces_show.device.mapper.DeviceMapper;
import cn.dcminfc.ces_show.device.service.DeviceService;
import cn.dcminfc.ces_show.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public Boolean isCanUse(String deviceId) {
        try {
            DeviceDomain query = new DeviceDomain(deviceId);
            DeviceDomain deviceDomain = deviceMapper.selectOne(query);
            if (deviceDomain == null) {
                return false;
            } else {
                return deviceDomain.getStatus() == Constant.DEVICE_STATUS_IDLE;
            }
        } catch (Exception e) {
            System.out.println("查询设备状态出现错误：" + e.toString());
            return false;
        }
    }

    @Override
    public Boolean checkCMD(String deviceId,String cmd) {
//        DeviceDomain query = new DeviceDomain(deviceId);
        DeviceDomain deviceDomain = deviceMapper.selectOneByDeviceId(deviceId);

        if (Constant.CMD_OPENDOOR.equals(cmd)) {
            if (Constant.DEVICE_STATUS_IDLE == deviceDomain.getStatus()) {
                return true;
            }
        }
        if (Constant.CMD_START.equals(cmd)) {
            if (Constant.DEVICE_STATUS_OPEN == deviceDomain.getStatus()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Boolean isHas(String deviceId) {
//        DeviceDomain query = new DeviceDomain(deviceId);
        DeviceDomain deviceDomain = deviceMapper.selectOneByDeviceId(deviceId);
        if (deviceDomain == null) {
            return false;
        } else {
            return true;
        }
    }
}
