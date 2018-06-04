package cn.dcminfc.ces_show.user.service;

import cn.dcminfc.ces_show.user.domain.UserDomain;
import com.iot.util.ReturnData;

public interface UserService {
    ReturnData putUser(String tmpCode);

    Boolean checkUser(String openid);
}
