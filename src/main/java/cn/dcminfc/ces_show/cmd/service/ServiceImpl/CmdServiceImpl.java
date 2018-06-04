package cn.dcminfc.ces_show.cmd.service.ServiceImpl;



import cn.dcminfc.ces_show.cmd.domain.CmdDomain;
import cn.dcminfc.ces_show.cmd.mapper.CmdMapper;
import cn.dcminfc.ces_show.cmd.service.CmdService;
import cn.dcminfc.ces_show.device.service.DeviceService;
import cn.dcminfc.ces_show.user.service.UserService;
import cn.dcminfc.ces_show.utils.*;
import com.iot.util.ReturnData;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmdServiceImpl implements CmdService{
    @Autowired
    private CmdMapper cmdMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private DeviceService deviceService;

    private CmdDomain cmdDomain;

    @Override
    public ReturnData putCmd(CmdDomain cmdDomain) {
        System.out.println(JSONObject.fromObject(cmdDomain).toString());
        Result result;
        //1、检查数据状态
        result = checkParms(cmdDomain);
        if (!Constant.RESULT_00.getCode().equals(result.getCode())) {
            return DealReturnData.result(result);
        }

        //2、检查用户是否有权限
        if (!userService.checkUser(cmdDomain.getOpenId())) {
            return DealReturnData.result(Constant.RESULT_E0202);
        }

        //3、检查设备的状态
        if (!deviceService.checkCMD(Constant.DEVICE_DEFAULT, cmdDomain.getCmd())) {
            return DealReturnData.result(Constant.RESULT_E0203);
        }

        //插入数据库
        result = insertCmd(cmdDomain);
        if (!Constant.RESULT_00.getCode().equals(result.getCode())) {
            return DealReturnData.result(result);
        }

        return DealReturnData.result(Constant.RESULT_00);
    }

    private Result insertCmd(CmdDomain cmdDomain) {
        cmdDomain.setDeviceId(Constant.DEVICE_DEFAULT);
        cmdDomain.setFlag(Constant.CMD_FLAG_WAIT);
        int result = cmdMapper.insert(cmdDomain);
        if (result == 1) {
            return Constant.RESULT_00;
        } else {
            return Constant.RESULT_E0201;
        }
    }

    private Result checkParms(CmdDomain cmdDomain) {
        if (StringUtils.isEmpty(cmdDomain.getCmd()) || StringUtils.isEmpty(cmdDomain.getOpenId())) {
            return Constant.RESULT_EFF01;
        } else {
            return Constant.RESULT_00;
        }
    }

    @Override
    public String getCmd(String deviceId) {
        System.out.println(deviceId);
        Result result;
        //1、检查数据状态
        result = checkParms(deviceId);
        if (!Constant.RESULT_00.getCode().equals(result.getCode())) {
            return "";
        }

        //2、检查设备是否被注册
        if (!deviceService.isHas(deviceId)) {
            return "";
        }

        //3、获取命令
        result = queryCmd(deviceId);
        if (!Constant.RESULT_00.getCode().equals(result.getCode())){
            return "";
        }

        //4、将命令返回给设备
        ReturnData returnData = DealReturnData.result(Constant.RESULT_00);
        returnData.setContent(this.cmdDomain);
        return this.cmdDomain.getCmd();
    }

    private Result queryCmd(String deviceId) {
        CmdDomain query = new CmdDomain(deviceId,Constant.CMD_FLAG_WAIT);
        List<CmdDomain> cmdDomains = cmdMapper.select(query);
        if (cmdDomains.size() == 0) {
            return Constant.RESULT_E0302;
        } else {
            int size = cmdDomains.size();
            CmdDomain cmdDomainToDo = cmdDomains.get(size - 1);
            Long dt = TimeUtils.getDCurrentTime(cmdDomainToDo.getLastUpdateDate());
            if (dt > Constant.CMD_DEFULT_FAILTIME) {
                //将所有该设备的命令的flag 设备 used
                cmdMapper.changeALLflag(Constant.DEVICE_DEFAULT, Constant.CMD_FLAG_DEALED);
                return Constant.RESULT_E0302;
            } else {
                this.cmdDomain = cmdDomainToDo;
                cmdMapper.changeALLflag(Constant.DEVICE_DEFAULT, Constant.CMD_FLAG_DEALED);
//                cmdDomainToDo.setFlag(Constant.CMD_FLAG_WAIT);
//                cmdMapper.updateByPrimaryKey(cmdDomainToDo);
                return Constant.RESULT_00;
            }

        }
    }

    private Result checkParms(String deviceId) {
        if (StringUtils.isEmpty(deviceId)) {
            return Constant.RESULT_EFF01;
        } else {
            return Constant.RESULT_00;
        }
    }
}
