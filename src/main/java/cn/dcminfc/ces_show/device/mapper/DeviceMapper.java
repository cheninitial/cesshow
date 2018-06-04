package cn.dcminfc.ces_show.device.mapper;

import cn.dcminfc.ces_show.device.domain.DeviceDomain;
import cn.dcminfc.ces_show.user.domain.UserDomain;
import com.hand.hap.cloud.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface DeviceMapper extends BaseMapper<DeviceDomain> {

    DeviceDomain selectOneByDeviceId(@Param("deviceId") String deviceId);

}
