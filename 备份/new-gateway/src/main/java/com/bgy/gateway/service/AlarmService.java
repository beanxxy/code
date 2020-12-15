package com.bgy.gateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bgy.gateway.model.dto.PlcAlarmInfo;
import com.bgy.gateway.model.entity.PlcAlarmEntity;

import java.util.List;


/**
 * @author caijunwei
 * date 2020/11/26 9:34
 */
public interface AlarmService extends IService<PlcAlarmEntity> {


    /**
     * 批量插入
     * @param plcAlarmInfoList
     * @return
     */
    boolean saveBatch(List<PlcAlarmInfo> plcAlarmInfoList);

    /**
     * 批量删除
     * @param plcAlarmInfoList
     * @return
     */
    int delete(List<PlcAlarmInfo> plcAlarmInfoList);
}
