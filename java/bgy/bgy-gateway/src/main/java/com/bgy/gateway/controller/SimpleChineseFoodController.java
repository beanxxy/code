package com.bgy.gateway.controller;

import com.bgy.gateway.model.dto.cold.ColdSimpleChineseFoodOutDto;
import com.bgy.gateway.model.vo.ResultVo;
import com.bgy.gateway.service.store.SimpleChineseFoodService;
import com.bgy.gateway.validator.ValidatorImpl;
import com.bgy.gateway.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simpleChineseFood")
@Api(tags = "简易中餐")
public class SimpleChineseFoodController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleChineseFoodController.class);

    @Autowired
    private ValidatorImpl validator;

    @Autowired
    private SimpleChineseFoodService simpleChineseFoodService;

    @RequestMapping(value = "/cook", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="发送烹饪命令")
    public ResultVo cook(@RequestBody ColdSimpleChineseFoodOutDto coldSimpleChineseFoodOutDto) throws BusinessException {
        LOGGER.info("简易中餐，发送烹饪命令：{}", coldSimpleChineseFoodOutDto);
        validator.validate(coldSimpleChineseFoodOutDto);
        return simpleChineseFoodService.sendColdCommand(coldSimpleChineseFoodOutDto);
    }
}
