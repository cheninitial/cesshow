package cn.dcminfc.ces.controller;

import cn.dcminfc.ces.pojo.UserReqBody;
import cn.dcminfc.ces.pojo.UserRspBody;
import cn.dcminfc.ces.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/user")
    @ResponseBody
    public UserRspBody user(@RequestBody UserReqBody userReqBody){
        return userService.user(userReqBody);
    }

    @GetMapping("/test")
    @ResponseBody
    public String userTest(){
        return "userTest";
    }
}
