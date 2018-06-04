package cn.dcminfc.ces_show.cmd.mapper;

import cn.dcminfc.ces_show.cmd.domain.CmdDomain;
import cn.dcminfc.ces_show.utils.Constant;
import com.hand.hap.cloud.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CmdMapper extends BaseMapper<CmdDomain>{

    int changeALLflag(@Param("deviceId") String deviceId, @Param("flag") int flag);

}
