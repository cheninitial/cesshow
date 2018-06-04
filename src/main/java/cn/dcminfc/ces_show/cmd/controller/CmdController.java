package cn.dcminfc.ces_show.cmd.controller;


import cn.dcminfc.ces_show.cmd.domain.CmdDomain;
import cn.dcminfc.ces_show.cmd.service.CmdService;
import com.hand.hap.cloud.resource.exception.HapException;
import com.iot.util.ReturnData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v2/cmd")
public class CmdController {
    @Autowired
    CmdService cmdService;

    @PostMapping("/put")
    public ResponseEntity<ReturnData> userControl(@RequestBody(required = true) CmdDomain cmdDomain) throws HapException {
        return Optional.ofNullable(cmdService.putCmd(cmdDomain))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseThrow(() -> new HapException("error.id.notFound"));
    }

    @GetMapping("/get")
    public ResponseEntity<String> userControl(@Param("deviceId") String deviceId) throws HapException {
        return Optional.ofNullable(cmdService.getCmd(deviceId))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseThrow(() -> new HapException("error.id.notFound"));
    }
}
