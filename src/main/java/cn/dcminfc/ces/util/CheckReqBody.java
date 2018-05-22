package cn.dcminfc.ces.util;

import cn.dcminfc.ces.pojo.UserReqBody;

public class CheckReqBody {
    public static Boolean checkUser(UserReqBody userReqBody){
        if (userReqBody == null) {
            return false;
        } else if (userReqBody.getCmdType() == null ||
                userReqBody.getName() == null ||
                userReqBody.getPicUrl() == null
                ) {
            return false;
        } else {
            return true;
        }
    }
}
