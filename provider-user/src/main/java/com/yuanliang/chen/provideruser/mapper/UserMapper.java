package com.yuanliang.chen.provideruser.mapper;

import com.yuanliang.chen.provideruser.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: yuanliang.chen
 * @Description:
 * @Date: 22:05 2018/4/22
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user_info WHERE id = #{id}")
    User findUserById(@Param("id") int id);
}
