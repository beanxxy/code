package com.bgy.gateway.controller;

import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.dto.down.DownChineseFoodCheckDto;
import com.bgy.gateway.model.dto.down.DownChineseFoodOutDto;
import com.bgy.gateway.model.dto.steam.SteamChineseFoodOutDto;
import com.bgy.gateway.model.dto.updish.UpdishChineseFoodOutDto;
import com.bgy.gateway.model.vo.ResultVo;
import com.bgy.gateway.service.store.ChineseFoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chinesefood")
@Api(tags = "中餐厅")
public class ChineseFoodController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChineseFoodController.class);


    @Autowired
    private ChineseFoodService chineseFoodService;

    @RequestMapping(value = "/up/start", method = RequestMethod.POST)
    @ApiOperation(value="发送人工上菜口上升命令")
    public ResultVo upStart(@RequestBody @Validated UpdishChineseFoodOutDto updishChineseFoodOutDto) throws BusinessException {
        LOGGER.info("中餐厅上菜口设备，发送人工上升命令：{}", updishChineseFoodOutDto);
        updishChineseFoodOutDto.setCommand(2);
        return chineseFoodService.sendUpdishCommand(updishChineseFoodOutDto);
    }

    @RequestMapping(value = "/cook", method = RequestMethod.POST)
    @ApiOperation(value="发送下发烹饪命令")
    public ResultVo cook(@RequestBody @Validated UpdishChineseFoodOutDto updishChineseFoodOutDto) throws BusinessException {
        LOGGER.info("中餐厅上菜口设备，发送下发烹饪菜品命令：{}", updishChineseFoodOutDto);
        updishChineseFoodOutDto.setCommand(updishChineseFoodOutDto.getCommand());
        return chineseFoodService.sendUpdishCommand(updishChineseFoodOutDto);
    }

    @RequestMapping(value = "/up/push", method = RequestMethod.POST)
    @ApiOperation(value="上菜口发送推杆命令")
    public ResultVo upPush(@RequestBody @Validated UpdishChineseFoodOutDto updishChineseFoodOutDto) throws BusinessException {
        LOGGER.info("中餐厅上菜口设备，发送推杆命令：{}", updishChineseFoodOutDto);
        updishChineseFoodOutDto.setCommand(3);
        return chineseFoodService.sendUpdishCommand(updishChineseFoodOutDto);
    }


    @RequestMapping(value = "/down/push", method = RequestMethod.POST)
    @ApiOperation(value="下菜口发送AGV到达推杆命令")
    public ResultVo downPush(@RequestBody @Validated DownChineseFoodOutDto downChineseFoodOutDto) throws BusinessException {
        LOGGER.info("中餐厅下菜口设备，发送AGV到达推杆命令：{}", downChineseFoodOutDto);
        downChineseFoodOutDto.setCommand(2);
        return chineseFoodService.sendDownCommand(downChineseFoodOutDto);
    }
    
    
    @RequestMapping(value = "/up/check", method = RequestMethod.POST)
    @ApiOperation(value="上菜口发送检点命令")
    public ResultVo checkup(@RequestBody @Validated DownChineseFoodCheckDto downChineseFoodCheckDto) throws BusinessException {
        LOGGER.info("中餐厅上菜口设备，发送检点命令：{}", downChineseFoodCheckDto);
        downChineseFoodCheckDto.setCommand(2);
        return chineseFoodService.sendDownCheckCommand(downChineseFoodCheckDto);
    } 
    
    @RequestMapping(value = "/down/check", method = RequestMethod.POST)
    @ApiOperation(value="下菜口发送检点命令")
    public ResultVo check(@RequestBody @Validated DownChineseFoodCheckDto downChineseFoodCheckDto) throws BusinessException {
        LOGGER.info("中餐厅下菜口设备，发送检点命令：{}", downChineseFoodCheckDto);
        downChineseFoodCheckDto.setCommand(2);
        return chineseFoodService.sendDownCheckCommand(downChineseFoodCheckDto);
    } 

    @RequestMapping(value = "/down/back", method = RequestMethod.POST)
    @ApiOperation(value="下菜口发送AGV离开推杆收回命令")
    public ResultVo downBack(@RequestBody @Validated DownChineseFoodOutDto downChineseFoodOutDto) throws BusinessException {
        LOGGER.info("中餐厅下菜口设备，发送AGV离开推杆收回命令：{}", downChineseFoodOutDto);
        downChineseFoodOutDto.setCommand(3);
        return chineseFoodService.sendDownCommand(downChineseFoodOutDto);
    }

    @RequestMapping(value = "/steam/replenish", method = RequestMethod.POST)
    @ApiOperation(value="发送蒸箱备料命令")
    public ResultVo replenish(@RequestBody @Validated SteamChineseFoodOutDto steamChineseFoodOutDto) throws BusinessException {
        LOGGER.info("中餐厅蒸箱设备，发送蒸箱备料命令：{}", steamChineseFoodOutDto);
        steamChineseFoodOutDto.setCommand(1);
        return chineseFoodService.sendSteamCommand(steamChineseFoodOutDto);
    }


    @RequestMapping(value = "/up/push/reaffirm", method = RequestMethod.POST)
    @ApiOperation(value="上菜口发送推杆确认命令")
    public ResultVo upPushReaffirm(@RequestBody @Validated UpdishChineseFoodOutDto updishChineseFoodOutDto) throws BusinessException {
        LOGGER.info("中餐厅上菜口设备，发送推杆确认命令：{}", updishChineseFoodOutDto);
        updishChineseFoodOutDto.setCommand(7);
        return chineseFoodService.sendUpdishCommand(updishChineseFoodOutDto);
    }

}
