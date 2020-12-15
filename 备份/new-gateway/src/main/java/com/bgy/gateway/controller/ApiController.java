package com.bgy.gateway.controller;

import com.bgy.gateway.enums.NumberEnum;
import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.dto.ParamDTO;
import com.bgy.gateway.model.vo.ResultVO;
import com.bgy.gateway.service.DriveDeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caijunwei
 * date 2020/11/26 16:42
 */
@Slf4j
@RestController
@RequestMapping("/gateway")
@Api(tags = "提供状态引擎接口")
public class ApiController {

    @Autowired
    DriveDeviceService driveDeviceService;

    @RequestMapping(value = "/receive/data", method = RequestMethod.POST)
    @ApiOperation(value="发送制作命令")
    public ResultVO placeOrder(@RequestBody @Validated String param) throws BusinessException {
        log.info("调度引擎发送命令：{}", param);
        return driveDeviceService.managerDevice(param, NumberEnum.ONE.getValues());
    }

    @RequestMapping(value = "/close/callback", method = RequestMethod.POST)
    @ApiOperation(value="发送结束回调命令")
    public ResultVO closeCallback(@RequestBody @Validated String param) throws BusinessException {
        log.info("调度引擎发送结束回调命令：{}", param);
        return driveDeviceService.managerDevice(param,NumberEnum.TWO.getValues());
    }


}
