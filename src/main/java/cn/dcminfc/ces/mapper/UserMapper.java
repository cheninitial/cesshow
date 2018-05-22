package cn.dcminfc.ces.mapper;

import cn.dcminfc.ces.domain.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.stream.BaseStream;

@Mapper
public interface UserMapper extends BaseMapper<User>{

}
