package com.bgy.gateway.controller;

import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.vo.ResultVo;
import com.bgy.gateway.netty.ChannelSupervise;
import com.bgy.gateway.util.TaskUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caijunwei
 * date 2020/3/8 20:15
 */

@RestController
@RequestMapping("/service")
@Api(tags = "任务")
public class TaskController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);


    @RequestMapping(value = "/show/heart/log", method = RequestMethod.POST)
    @ApiOperation(value="是否启用心跳日志显示")
    public ResultVo outDish(@RequestBody Boolean tag) {
        LOGGER.info("是否启用心跳日志显示：{}", tag);
        TaskUtil.setHeartLog(tag);
        return ResultVo.success();
    }

    @RequestMapping(value = "/check/heart", method = RequestMethod.POST)
    @ApiOperation(value="是否启用心跳检测")
    public ResultVo check(@RequestBody Boolean tag) {
        LOGGER.info("是否启用心跳检测：{}", tag);
        TaskUtil.setHeartCheck(tag);
        return ResultVo.success();
    }

    @RequestMapping(value = "/get/login/message", method = RequestMethod.POST)
    @ApiOperation(value="获取已登录设备")
    public ResultVo getLogin()  {
        return ResultVo.success(ChannelSupervise.getLoginMessage());
    }

    @RequestMapping(value = "/push/device/system", method = RequestMethod.POST)
    @ApiOperation(value="是否启用推送设备管理系统")
    public Object pushDevice(@RequestBody Boolean tag)  {
        LOGGER.info("是否启用推送设备管理系统：{}", tag);
        TaskUtil.setPushDeviceSystem(tag);
        return ResultVo.success();
    }
}
