package com.bgy.gateway.controller;

import com.bgy.gateway.model.dto.steam.SteamSelfFastFoodOutDto;
import com.bgy.gateway.model.vo.ResultVo;
import com.bgy.gateway.service.store.FastFoodSteamSlefService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

/**
 * @author lzx
 * @date 2020/3/19.
 */
@Slf4j
@RestController
@RequestMapping("/fastfood/steam")
@Api(tags = "快餐厅")
public class FastFoodSelfController {

    @Autowired
    FastFoodSteamSlefService fastFoodSteamSlefService;

    @PostMapping("/out")
    @ApiOperation(value = "自助式蒸箱发送出料指令")
    public ResultVo outDish(@RequestBody @Validated SteamSelfFastFoodOutDto steamSelfFastFoodOutDto) {
        log.info("快餐厅自助式蒸箱发送出料指令：[{}]", steamSelfFastFoodOutDto);

        //下发命令类型
        steamSelfFastFoodOutDto.setCommand(1);
        ResultVo result = fastFoodSteamSlefService.sendSteamSelfFastFoodOut(steamSelfFastFoodOutDto);
        return result;
    }

    @PostMapping("/out/reconfirm")
    @ApiOperation(value = "自助式蒸箱发送出料确认指令")
    public ResultVo outDishReconfirm(@RequestBody @Validated SteamSelfFastFoodOutDto steamSelfFastFoodOutDto) {
        log.info("快餐厅自助式蒸箱发送出料确认指令：[{}]", steamSelfFastFoodOutDto);
        //下发命令类型
        steamSelfFastFoodOutDto.setCommand(2);
        ResultVo result = fastFoodSteamSlefService.sendSteamSelfFastFoodOut(steamSelfFastFoodOutDto);
        return result;
    }
}

