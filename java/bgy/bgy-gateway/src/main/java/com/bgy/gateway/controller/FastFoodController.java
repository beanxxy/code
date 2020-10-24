package com.bgy.gateway.controller;

import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.dto.belt.BeltStreamFastFoodOutDto;
import com.bgy.gateway.model.dto.steam.SteamCageAssemblyDto;
import com.bgy.gateway.model.dto.steam.SteamDoorUpDownDto;
import com.bgy.gateway.model.dto.steam.SteamFastFoodOutDto;
import com.bgy.gateway.model.dto.taker.TakerOutDto;
import com.bgy.gateway.model.vo.ResultVo;
import com.bgy.gateway.service.store.FastFoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fastfood")
@Api(tags = "快餐厅")
public class FastFoodController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FastFoodController.class);


    @Autowired
    private FastFoodService fastFoodService;

    @RequestMapping(value = "/steam/replenish", method = RequestMethod.POST)
    @ApiOperation(value="发送蒸箱备料命令")
    public ResultVo replenish(@RequestBody @Validated SteamFastFoodOutDto streamFastFoodOutDto) throws BusinessException {
        LOGGER.info("快餐厅蒸箱，发送备料命令：{}", streamFastFoodOutDto);
        streamFastFoodOutDto.setCommand(1);
        return fastFoodService.sendStreamCommand(streamFastFoodOutDto);
    }

    @RequestMapping(value = "/steam/replenish/reaffirm", method = RequestMethod.POST)
    @ApiOperation(value="发送蒸箱备料确认命令")
    public ResultVo replenishReaffirm(@RequestBody @Validated SteamFastFoodOutDto streamFastFoodOutDto) throws BusinessException {
        LOGGER.info("快餐厅蒸箱，发送备料确认命令：{}", streamFastFoodOutDto);
        streamFastFoodOutDto.setCommand(2);
        return fastFoodService.sendStreamCommand(streamFastFoodOutDto);
    }

    @RequestMapping(value = "/steam/out/dish", method = RequestMethod.POST)
    @ApiOperation(value="发送蒸箱出料命令")
    public ResultVo outDish(@RequestBody @Validated BeltStreamFastFoodOutDto beltStreamFastFoodOutDto) throws BusinessException {
        LOGGER.info("快餐厅蒸箱，发送出料命令：{}", beltStreamFastFoodOutDto);
        beltStreamFastFoodOutDto.setCommand(1);
        return fastFoodService.sendStreamCommand(beltStreamFastFoodOutDto);
    }

    @RequestMapping(value = "/steam/out/dish/reaffirm", method = RequestMethod.POST)
    @ApiOperation(value="发送蒸箱出料确认命令")
    public ResultVo outDishReaffirm(@RequestBody @Validated BeltStreamFastFoodOutDto beltStreamFastFoodOutDto) throws BusinessException {
        LOGGER.info("快餐厅蒸箱，发送出料确认命令：{}", beltStreamFastFoodOutDto);
        beltStreamFastFoodOutDto.setCommand(2);
        return fastFoodService.sendStreamCommand(beltStreamFastFoodOutDto);
    }

    @RequestMapping(value = "/steam/up/down", method = RequestMethod.POST)
    @ApiOperation(value="发送蒸箱升降命令")
    public ResultVo upDown(@RequestBody @Validated SteamCageAssemblyDto steamCageAssemblyDto) throws BusinessException {
        LOGGER.info("快餐厅一体化蒸箱，发送蒸箱升降命令：{}", steamCageAssemblyDto);
        steamCageAssemblyDto.setCommand(3);
        return fastFoodService.sendStreamCommand(steamCageAssemblyDto);
    }

    @RequestMapping(value = "/steam/up/down/reaffirm", method = RequestMethod.POST)
    @ApiOperation(value="发送蒸箱升降确认命令")
    public ResultVo upDownReaffirm(@RequestBody @Validated SteamCageAssemblyDto steamCageAssemblyDto) throws BusinessException {
        LOGGER.info("快餐厅一体化蒸箱，发送蒸箱升降确认命令：{}", steamCageAssemblyDto);
        steamCageAssemblyDto.setCommand(4);
        return fastFoodService.sendStreamCommand(steamCageAssemblyDto);
    }

    @RequestMapping(value = "/open/taker", method = RequestMethod.POST)
    @ApiOperation(value="发送取餐柜开门接口命令")
    public ResultVo openDoor(@RequestBody @Validated TakerOutDto takerOutDto) throws BusinessException {
        LOGGER.info("快餐厅蒸箱，发送取餐柜开门命令：{}", takerOutDto);
        takerOutDto.setCommand(3);
        return fastFoodService.sendStreamCommand(takerOutDto);
    }

    @RequestMapping(value = "/open/taker/reaffirm", method = RequestMethod.POST)
    @ApiOperation(value="发送取餐柜开门确认接口命令")
    public ResultVo reaffirm(@RequestBody @Validated TakerOutDto takerOutDto) throws BusinessException {
        LOGGER.info("快餐厅蒸箱，发送取餐柜开门确认命令：{}", takerOutDto);
        takerOutDto.setCommand(4);
        return fastFoodService.sendStreamCommand(takerOutDto);
    }

    @RequestMapping(value = "/operate/door", method = RequestMethod.POST)
    @ApiOperation(value="发送蒸箱开关门命令")
    public ResultVo operateDoor(@RequestBody @Validated SteamDoorUpDownDto steamDoorUpDownDto) throws BusinessException {
        LOGGER.info("快餐厅蒸箱，发送开关门命令：{}", steamDoorUpDownDto);
        steamDoorUpDownDto.setCommand(5);
        return fastFoodService.sendStreamCommand(steamDoorUpDownDto);
    }

    @RequestMapping(value = "/operate/door/reaffirm", method = RequestMethod.POST)
    @ApiOperation(value="发送蒸箱开关门确认命令")
    public ResultVo operateDoorReaffirm(@RequestBody @Validated SteamDoorUpDownDto steamDoorUpDownDto) throws BusinessException {
        LOGGER.info("快餐厅蒸箱，发送开关门确认命令：{}", steamDoorUpDownDto);
        steamDoorUpDownDto.setCommand(6);
        return fastFoodService.sendStreamCommand(steamDoorUpDownDto);
    }
}
