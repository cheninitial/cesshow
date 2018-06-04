package cn.dcminfc.ces_show.user.controller;

import cn.dcminfc.ces_show.user.domain.UserDomain;
import cn.dcminfc.ces_show.user.service.UserService;
import com.hand.hap.cloud.resource.exception.HapException;
import com.iot.util.ReturnData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v2/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/put")
    public ResponseEntity<ReturnData> userControl(@Param("tempCode") String tmpCode) throws HapException {
        return Optional.ofNullable(userService.putUser(tmpCode))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseThrow(() -> new HapException("error.id.notFound"));
    }
}
