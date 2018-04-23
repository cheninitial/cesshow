package com.yuanliang.chen.consumer_movie.controller;

import com.yuanliang.chen.consumer_movie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: yuanliang.chen
 * @Description:
 * @Date: 22:30 2018/4/23
 */
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User fandById(@PathVariable Long id){
        return this.restTemplate.getForObject("http://localhost:8011/" + id, User.class);
    }
}
