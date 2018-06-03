package cn.dcminfc.ces.service.impl;

import cn.dcminfc.ces.domain.User;
import cn.dcminfc.ces.mapper.UserMapper;
import cn.dcminfc.ces.pojo.UserReqBody;
import cn.dcminfc.ces.pojo.UserRspBody;
import cn.dcminfc.ces.service.UserService;
import cn.dcminfc.ces.util.CheckReqBody;
import cn.dcminfc.ces.util.ConstantResult;
import cn.dcminfc.ces.util.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public UserRspBody user(UserReqBody userReqBody) {
        Boolean checkResult = CheckReqBody.checkUser(userReqBody);
        if (!checkResult){
            return new UserRspBody(ConstantResult.HTTP_BODY_ERROR);
        }
        Boolean parsResult = parsUser(userReqBody);
        if (!parsResult) {
            return new UserRspBody(ConstantResult.MYSQL_ERROR);
        }else {
            return new UserRspBody(ConstantResult.SUCCESS);
        }
    }

    private Boolean parsUser(UserReqBody userReqBody) {
        User userIndex = new User(userReqBody.getName(),userReqBody.getPicUrl());
        User user = userMapper.selectOne(userIndex);
        if (user == null) {
            userIndex.setCreateTime(Time.getTime(Time.TYPE_YMDHMS));
            int result = userMapper.insert(userIndex);
            return result != 0;
        } else {
            int result = userMapper.updateByPrimaryKey(user);
            return result != 0;
        }
    }
}
