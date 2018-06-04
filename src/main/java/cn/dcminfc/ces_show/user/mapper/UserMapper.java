package cn.dcminfc.ces_show.user.mapper;

import cn.dcminfc.ces_show.user.domain.UserDomain;
import com.hand.hap.cloud.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<UserDomain> {
    int changeALLflag(@Param("flag") int flag);

    UserDomain selectOneByOpenID(@Param("openId") String openId);

}
