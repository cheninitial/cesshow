package com.yuanliang.chen.consumer_movie.pojo;

import java.math.BigDecimal;

/**
 * @Author: yuanliang.chen
 * @Description:
 * @Date: 22:27 2018/4/23
 */
public class User {
    private int id;
    private String username;
    private String name;
    private int age;
    private BigDecimal balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
