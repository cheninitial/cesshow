package com.yuanliang.chen.provideruser.controller;

import com.yuanliang.chen.provideruser.dao.User;
import com.yuanliang.chen.provideruser.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yuanliang.chen
 * @Description:
 * @Date: 22:14 2018/4/22
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public User findById(@PathVariable int id){
        User findOne = this.userMapper.findUserById(id);
        return findOne;
    }
}
