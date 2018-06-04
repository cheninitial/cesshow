package cn.dcminfc.ces_show.user.service.serviceImpl;

import cn.dcminfc.ces_show.device.service.DeviceService;
import cn.dcminfc.ces_show.user.domain.UserDomain;
import cn.dcminfc.ces_show.user.mapper.UserMapper;
import cn.dcminfc.ces_show.user.pojo.RspUserPojo;
import cn.dcminfc.ces_show.user.service.UserService;
import cn.dcminfc.ces_show.utils.*;
import com.iot.util.ReturnData;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DeviceService deviceService;

    private String openId;

    @Override
    public ReturnData putUser(String tmpCode) {
        Result result;
        //1、检查数据状态
        result = checkParms(tmpCode);
        if (!Constant.RESULT_00.getCode().equals(result.getCode())) {
            return DealReturnData.result(result);
        }

        //2、查询设备状态是否可用
        if (!deviceService.isCanUse(Constant.DEVICE_DEFAULT)) {
            return DealReturnData.result(Constant.RESULT_E0103);
        }

        //3、获取用户的openID
        result = getOpenId(tmpCode);
        if (!Constant.RESULT_00.getCode().equals(result.getCode())) {
            return DealReturnData.result(result);
        }

        //4、修改用户的数据库信息
        result = insertSqlUser(this.openId);
        if (!Constant.RESULT_00.getCode().equals(result.getCode())) {
            return DealReturnData.result(result);
        }

        //5、最终返回给WX请求openId
        RspUserPojo rspUserPojo = new RspUserPojo(openId);
        ReturnData returnData = DealReturnData.result(Constant.RESULT_00);
        returnData.setContent(rspUserPojo);
        return returnData;
    }

    private Result insertSqlUser(String openId) {
        UserDomain query = new UserDomain(openId);
        UserDomain userDomain = userMapper.selectOneByOpenID(openId);
        int changeNum = userMapper.changeALLflag(Constant.USER_FLAG_LIMITED);
        if (changeNum == 0) {
            return Constant.RESULT_E0101;
        }
        if (userDomain == null) {
            query.setFlag(Constant.USER_FLAG_CANUSE);
            int result = userMapper.insert(query);
            if (result == 1) {
                return Constant.RESULT_00;
            } else {
                return Constant.RESULT_E0101;
            }
        } else {
            userDomain.setFlag(Constant.USER_FLAG_CANUSE);
            int result = userMapper.updateByPrimaryKey(userDomain);
            if (result == 1) {
                return Constant.RESULT_00;
            } else {
                return Constant.RESULT_E0101;
            }
        }

    }

    private Result getOpenId(String tmpCode) {
        if (Constant.stub == 1) {
            this.openId = tmpCode;
            return Constant.RESULT_00;
        }
        RestTemplate restTemplate = new RestTemplate();
        String url = Constant.URL_WXUSER + "?appid=" + Constant.APPID + "&secret=" + Constant.AppSecret + "&js_code=" + tmpCode + "&grant_type=authorization_code";
        System.out.println("\nAAAAAAAAA请求URL："+url + "\n");
        String rspResponse = restTemplate.getForEntity(url, String.class).getBody();
        System.out.println("\n"+"AAAAAAAA请求的回复：" + rspResponse +"\n");
        if (rspResponse.contains(Constant.WX_OPENID_HTTP_KEY1) && rspResponse.contains(Constant.WX_OPENID_HTTP_KEY2)) {
            JSONObject jsonObject = JSONObject.fromObject(rspResponse);
            this.openId = jsonObject.getString(Constant.WX_OPENID_HTTP_KEY2);
            return Constant.RESULT_00;
        } else {
            return Constant.RESULT_E0102;
        }

    }

    private Result checkParms(String tmpCode) {
        if (StringUtils.isEmpty(tmpCode)) {
            return Constant.RESULT_EFF01;
        } else {
            return Constant.RESULT_00;
        }
    }

    @Override
    public Boolean checkUser(String openId) {
        //1、数据库中获取用户信息
//        UserDomain query = new UserDomain(openId);
        UserDomain userDomain = userMapper.selectOneByOpenID(openId);
        if (userDomain == null) {
            return false;
        }

        //2、判断刷新时间是否满足
        Date date = userDomain.getLastUpdateDate();
        Long dTime = TimeUtils.getDCurrentTime(date);
        if (dTime > Constant.USER_DEFAULT_FAILTIME) {
            return false;
        }

        //3、判断user的flag
        int flag = userDomain.getFlag();
        if (flag != Constant.USER_FLAG_CANUSE) {
            return false;
        }

        return true;
    }
}
