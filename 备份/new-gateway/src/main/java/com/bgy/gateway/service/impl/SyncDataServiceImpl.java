package com.bgy.gateway.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.bgy.gateway.enums.NumberEnum;
import com.bgy.gateway.enums.ResultEnum;
import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.dto.*;
import com.bgy.gateway.model.vo.ResultVO;
import com.bgy.gateway.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/12/9 10:02
 */
@Slf4j
@Service
public class SyncDataServiceImpl implements SyncDataService {

    @Autowired
    PlcService plcService;
    @Autowired
    ComponentService componentService;
    @Autowired
    DataModelService modelService;
    @Autowired
    FunctionService functionService;
    @Autowired
    ConfigVersionService configVersionService;
    @Autowired
    MonitorService monitorService;
    @Autowired
    AlarmService alarmService;



    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public ResultVO syncData(String data) throws BusinessException {
        try {
            log.info("=同步plc数据：{}",data);
            BasicInfo basicInfo = JSONObject.parseObject(data,BasicInfo.class);
            List<PlcInfo> plcInfoList = basicInfo.getPlc();
            List<ConfigVersionInfo> versionInfoList = basicInfo.getPlcConfigVersion();
            List<DataModelInfo> modelInfoList = basicInfo.getPlcDataModel();
            List<FunctionInfo> functionInfoList = basicInfo.getPlcFunction();
            List<MonitorInfo> monitorInfoList = basicInfo.getPlcMonitor();
            List<PlcAlarmInfo> plcAlarmInfoList = basicInfo.getPlcAlarm();
            List<ComponentInfo> componentInfoList = basicInfo.getPlcComponent();
            if (CollectionUtils.isEmpty(plcInfoList) || CollectionUtils.isEmpty(versionInfoList) || CollectionUtils.isEmpty(modelInfoList) || CollectionUtils.isEmpty(componentInfoList)
                    || CollectionUtils.isEmpty(functionInfoList) || CollectionUtils.isEmpty(monitorInfoList) || CollectionUtils.isEmpty(plcAlarmInfoList)) {
                log.error("同步的数据表数据存在空数据");
                return ResultVO.error(ResultEnum.SYNC_DATA_EMPTY_ERROR);
            }
            if( plcService.delete(plcInfoList)< NumberEnum.ONE.getValues() || !plcService.saveBatch(plcInfoList)){
                log.error("PLC表删除插入失败");
                throw new BusinessException(ResultEnum.PLC_INSERT_ERROR);
            }
            if(componentService.delete(componentInfoList)< NumberEnum.ONE.getValues()||!componentService.saveBatch(componentInfoList)){
                log.error("component组件表删除插入失败");
                throw new BusinessException(ResultEnum.COMPONENT_INSERT_ERROR);
            }
            if(modelService.delete(modelInfoList)< NumberEnum.ONE.getValues()||!modelService.saveBatch(modelInfoList)){
                log.error("data_mode模型组件表删除插入失败");
                throw new BusinessException(ResultEnum.DATA_MODEL_INSERT_ERROR);
            }
            if(functionService.delete(functionInfoList)< NumberEnum.ONE.getValues()||!functionService.saveBatch(functionInfoList)){
                log.error("function功能表删除插入失败");
                throw new BusinessException(ResultEnum.FUNCTION_INSERT_ERROR);
            }
            if(monitorService.delete(monitorInfoList)< NumberEnum.ONE.getValues()||!monitorService.saveBatch(monitorInfoList)){
                log.error("monitor监控表删除插入失败");
                throw new BusinessException(ResultEnum.MONITOR_INSERT_ERROR);
            }
            if(alarmService.delete(plcAlarmInfoList)< NumberEnum.ONE.getValues()||!alarmService.saveBatch(plcAlarmInfoList)){
                log.error("alarm报警表删除插入失败");
                throw new BusinessException(ResultEnum.ALARM_INSERT_ERROR);
            }
            if(configVersionService.delete(versionInfoList)< NumberEnum.ONE.getValues()||!configVersionService.saveBatch(versionInfoList)){
                log.error("config版本配置表删除插入失败");
                throw new BusinessException(ResultEnum.CONFIG_INSERT_ERROR);
            }
        }catch (Exception e){
            log.error("同步数据发生异常：{}",e);
            throw new BusinessException(ResultEnum.SYNC_DATA_EXCUTE_ERROR);
        }
        return ResultVO.success();
    }
}
