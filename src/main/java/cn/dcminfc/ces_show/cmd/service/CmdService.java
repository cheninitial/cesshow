package cn.dcminfc.ces_show.cmd.service;

import cn.dcminfc.ces_show.cmd.domain.CmdDomain;
import com.iot.util.ReturnData;

public interface CmdService {

    ReturnData putCmd(CmdDomain cmdDomain);

    ReturnData getCmd(String deviceId);
}
