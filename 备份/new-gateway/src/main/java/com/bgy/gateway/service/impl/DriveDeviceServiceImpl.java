package com.bgy.gateway.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bgy.gateway.constant.Constant;
import com.bgy.gateway.enums.NumberEnum;
import com.bgy.gateway.enums.ResultEnum;
import com.bgy.gateway.model.entity.ComponentEntity;
import com.bgy.gateway.model.entity.FunctionEntity;
import com.bgy.gateway.model.entity.PlcEntity;
import com.bgy.gateway.model.vo.*;
import com.bgy.gateway.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author caijunwei
 * date 2020/12/1 17:17
 */
@Slf4j
@Service
public class DriveDeviceServiceImpl implements DriveDeviceService {

    @Autowired
    PlcService plcService;

    @Autowired
    ComponentService componentService;

    @Autowired
    FunctionService functionService;

    @Autowired
    DataModelService modelService;

    @Autowired
    ClientService clientService;


    @Override
    public ResultVO managerDevice(String param,int type) {
        try {
            JSONObject jsonObj= JSON.parseObject(param);
            Integer componentCode=Integer.valueOf(jsonObj.getString(Constant.COMPONENTCODE));
            Integer functionCode=Integer.valueOf(jsonObj.getString(Constant.FUNCTIONCODE));
            Map<String,String> attrMap = new HashMap<>();
            ComponentEntity componentEntity = componentService.getComponentEntity(componentCode);
            if(StringUtils.isEmpty(componentEntity)){
                log.error("component组件表查询失败，componentCode参数：{}",componentCode);
                return ResultVO.error(ResultEnum.COMPONENT_QUERY_EMPTY_ERROR);
            }
            PlcEntity plcEntity = plcService.getPlcEntity(componentEntity.getPlcId());
            if(StringUtils.isEmpty(plcEntity)){
                log.error("plc表查询失败，plc参数：{}",componentEntity.getPlcId());
                return ResultVO.error(ResultEnum.PLC_QUERY_EMPTY_ERROR);
            }
            FunctionEntity functionEntity = functionService.getFunctionEntity(componentEntity.getId(), functionCode);
            if(StringUtils.isEmpty(functionEntity)){
                log.error("functionE表查询失败，参数component :{},functionCode：{}",componentEntity.getId(),functionCode);
                return ResultVO.error(ResultEnum.FUNCTION_QUERY_EMPTY_ERROR);
            }
            List<EventVO> eventList =modelService.listMonitorModel(componentEntity.getId());
            if(eventList.size()< NumberEnum.ONE.getValues()){
                return ResultVO.error(ResultEnum.MODEL_QUERY_EMPTY_ERROR);
            }
            PlcDataModelVO plcDataModelVO = new PlcDataModelVO();
            plcDataModelVO.setIp(plcEntity.getIp());
            plcDataModelVO.setPort(plcEntity.getPort());
            plcDataModelVO.setEndian(plcEntity.getBigEndian());
            plcDataModelVO.setProtocal(String.valueOf(plcEntity.getProtocolId()));
            List<DataModelVO> modelVOList = modelService.listDataModelEntity(functionEntity.getDataModelId());
            plcDataModelVO.setArrayDataModelVo(modelVOList);
            plcDataModelVO.setValue(param);
            plcDataModelVO.setAttr(attrMap);
            eventList.forEach(item -> {
                SimpleBaseEventVO simpleBaseEventVO = new SimpleBaseEventVO();
                simpleBaseEventVO.getAttr().put(Constant.CODE,String.valueOf(item.getCode()));
                plcDataModelVO.getEvent().put(item.getAddress(),simpleBaseEventVO);

            });
            if(NumberEnum.ONE.getValues()==type){
                clientService.write(plcDataModelVO).thenAccept(s->{
                    //获取结果
                    clientService.read(plcDataModelVO);
                });
            }else if(NumberEnum.TWO.getValues()==type){
                clientService.close(plcDataModelVO);
            }
        }catch (Exception e){
        	 //失败
            log.error("封装调用设备处理异常：{}",e);
            ResultVO.error(ResultEnum.ORDER_DEAIL_ERROR);
        }
        return ResultVO.success();
    }
}
