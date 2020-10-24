package com.bgy.gateway.controller;

import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.dto.belt.BeltHotpotOutDto;
import com.bgy.gateway.model.dto.cold.ColdHotpotOutDto;
import com.bgy.gateway.model.dto.cut.CutHotpotOutDto;
import com.bgy.gateway.model.dto.drink.DrinkHotpotOutDto;
import com.bgy.gateway.model.dto.table.TableHotpotOutDto;
import com.bgy.gateway.model.dto.updish.UpdishHotpotOutDto;
import com.bgy.gateway.model.vo.ResultVo;
import com.bgy.gateway.service.store.HotpotService;
import com.bgy.gateway.validator.ValidatorImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotpot")
@Api(tags = "火锅店")
public class HotpotController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotpotController.class);

    @Autowired
    private ValidatorImpl validator;

    @Autowired
    private HotpotService hotpotService;

    @RequestMapping(value = "/out/dish", method = RequestMethod.POST)
    @ApiOperation(value="发送冷库出菜命令")
    public ResultVo outDish(@RequestBody @Validated ColdHotpotOutDto coldHotpotOutDto) throws BusinessException {
        LOGGER.info("火锅店冷库，发送冷柜出菜命令：{}", coldHotpotOutDto);
        coldHotpotOutDto.setCommand(1);
        ResultVo resultVo = hotpotService.sendColdCommand(coldHotpotOutDto);
        LOGGER.info("火锅店冷库，发送冷柜出菜命令：{},回复结果code：{},message :{}", coldHotpotOutDto,resultVo.getCode(),resultVo.getMessage());
        return resultVo;
    }

    @RequestMapping(value = "/clean/stock", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="发送清除库存命令")
    public ResultVo cleanStock(@RequestBody @Validated ColdHotpotOutDto coldHotpotOutDto) throws BusinessException {
        LOGGER.info("火锅店冷库，发送清除库存命令：{}", coldHotpotOutDto);
        coldHotpotOutDto.setCommand(2);
        return hotpotService.sendColdCommand(coldHotpotOutDto);
    }

    @RequestMapping(value = "/allocate/dish", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="发送将盘子分配到指定餐桌命令")
    public ResultVo allocateDish(@RequestBody @Validated TableHotpotOutDto tableHotpotOutDto) throws BusinessException {
        LOGGER.info("火锅店餐桌，发送将盘子分配到指定餐桌命令：{}", tableHotpotOutDto);
        tableHotpotOutDto.setCommand(1);
        return hotpotService.sendTableCommand(tableHotpotOutDto);
    }

    @RequestMapping(value = "/query/dishes", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="发送查询当前餐桌菜品列表命令")
    public ResultVo queryDishes(@RequestBody @Validated TableHotpotOutDto tableHotpotOutDto) throws BusinessException {
        LOGGER.info("火锅店餐桌，发送查询当前餐桌菜品列表命令：{}", tableHotpotOutDto);
        tableHotpotOutDto.setCommand(2);
        return hotpotService.sendTableCommand(tableHotpotOutDto);
    }

    @RequestMapping(value = "/clean/table", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="餐桌发送清桌命令")
    public ResultVo cleanTable(@RequestBody @Validated TableHotpotOutDto tableHotpotOutDto) throws BusinessException {
        LOGGER.info("火锅店餐桌，发送清桌命令：{}", tableHotpotOutDto);
       // tableHotpotOutDto.setCommand(CommandType.THREE);
        tableHotpotOutDto.setCommand(3);
        return hotpotService.sendTableCommand(tableHotpotOutDto);
    }

    @RequestMapping(value = "/clean/dish", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="餐桌发送清菜命令")
    public ResultVo cleanDish(@RequestBody @Validated TableHotpotOutDto tableHotpotOutDto) throws BusinessException {
        LOGGER.info("火锅店餐桌，发送清菜命令：{}", tableHotpotOutDto);
        //tableHotpotOutDto.setCommand(CommandType.FOUR);
        tableHotpotOutDto.setCommand(4);
        return hotpotService.sendTableCommand(tableHotpotOutDto);
    }

    @RequestMapping(value = "/allocate/belt", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="发送给盘子分配物流线ID命令")
    public ResultVo allocateBelt(@RequestBody @Validated BeltHotpotOutDto beltHotpotOutDto) throws BusinessException {
        LOGGER.info("火锅店物流线，发送给盘子分配物流线ID命令：{}", beltHotpotOutDto);
        beltHotpotOutDto.setCommand(1);
        return hotpotService.sendBeltCommand(beltHotpotOutDto);
    }

    @RequestMapping(value = "/query/belt/dishes", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="发送查询当前物流线已分配的盘子rfid列表命令")
    public ResultVo queryBeltDishes(@RequestBody BeltHotpotOutDto beltHotpotOutDto) throws BusinessException {
        LOGGER.info("火锅店物流线，发送查询当前物流线已分配的盘子rfid列表命令：{}", beltHotpotOutDto);
        beltHotpotOutDto.setCommand(2);
        validator.validate(beltHotpotOutDto);
        return hotpotService.sendBeltCommand(beltHotpotOutDto);
    }

    @RequestMapping(value = "/clean/belt", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="发送清物流线命令")
    public ResultVo cleanBelt(@RequestBody @Validated BeltHotpotOutDto beltHotpotOutDto) throws BusinessException {
        LOGGER.info("火锅店物流线，发送清物流线命令：{}", beltHotpotOutDto);
        beltHotpotOutDto.setCommand(3);
        return hotpotService.sendBeltCommand(beltHotpotOutDto);
    }

    @RequestMapping(value = "/clean/rfid", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="物流线发送清餐盘命令")
    public ResultVo cleanRfid(@RequestBody @Validated BeltHotpotOutDto beltHotpotOutDto) throws BusinessException {
        LOGGER.info("火锅店物流线，发送清火锅店物流线命令：{}", beltHotpotOutDto);
        beltHotpotOutDto.setCommand(4);
        return hotpotService.sendBeltCommand(beltHotpotOutDto);
    }

    @RequestMapping(value = "/put/belt", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="发送把盘子放在环形带命令")
    public ResultVo putBelt(@RequestBody @Validated UpdishHotpotOutDto updishHotpotOutDto) throws BusinessException {
        LOGGER.info("火锅店人工上菜口，发送把盘子放在环形带命令：{}", updishHotpotOutDto);
        updishHotpotOutDto.setCommand(1);
        return hotpotService.sendUpdishCommand(updishHotpotOutDto);
    }

    @RequestMapping(value = "/out/drink", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="发送下发空杯的命令")
    public ResultVo outDrink(@RequestBody @Validated DrinkHotpotOutDto drinkHotpotOutDto) throws BusinessException {
        LOGGER.info("火锅店饮料机，发送下发空杯的命令：{}", drinkHotpotOutDto);
        drinkHotpotOutDto.setCommand(1);
        return hotpotService.sendDrinkCommand(drinkHotpotOutDto);
    }

    @RequestMapping(value = "/write/dishId", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="发送下发录碟命令")
    public ResultVo writeDishId(@RequestBody @Validated CutHotpotOutDto cutHotpotOutDto) throws BusinessException {
        LOGGER.info("火锅店切菜口，发送下发录碟的命令：{}", cutHotpotOutDto);
        cutHotpotOutDto.setCommand(1);
        return hotpotService.sendCutCommand(cutHotpotOutDto);
    }
}
