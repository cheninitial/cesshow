package cn.dcminfc.ces.controller;

import cn.dcminfc.ces.pojo.UserReqBody;
import cn.dcminfc.ces.pojo.UserRspBody;
import cn.dcminfc.ces.service.UserService;
import com.hand.hap.cloud.resource.exception.HapException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/user")
    public ResponseEntity<UserRspBody> user(@RequestBody UserReqBody userReqBody){
        return Optional.ofNullable(userService.user(userReqBody))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseThrow(() -> new HapException("error.iotRecvCmd"));
    }

}
