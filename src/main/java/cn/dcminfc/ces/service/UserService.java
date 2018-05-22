package cn.dcminfc.ces.service;

import cn.dcminfc.ces.pojo.UserReqBody;
import cn.dcminfc.ces.pojo.UserRspBody;

public interface UserService {
    UserRspBody user(UserReqBody reqBody);
}
