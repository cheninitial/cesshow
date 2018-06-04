package cn.dcminfc.ces_show.device.controller;

import cn.dcminfc.ces_show.device.service.DeviceService;
import com.hand.hap.cloud.resource.exception.HapException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v2/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping("/status")
    public ResponseEntity<String> userControl(@Param("status") int status) throws HapException {
        return Optional.ofNullable(deviceService.status(status))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseThrow(() -> new HapException("error.id.notFound"));
    }
}
