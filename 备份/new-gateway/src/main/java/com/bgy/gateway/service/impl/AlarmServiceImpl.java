package com.bgy.gateway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgy.gateway.dao.mapper.AlarmMapper;
import com.bgy.gateway.model.dto.PlcAlarmInfo;
import com.bgy.gateway.model.entity.PlcAlarmEntity;
import com.bgy.gateway.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/12/9 15:41
 */
@Service
public class AlarmServiceImpl extends ServiceImpl<AlarmMapper, PlcAlarmEntity> implements AlarmService {

    @Autowired
    AlarmMapper alarmMapper;

    @Override
    public boolean saveBatch(List<PlcAlarmInfo> plcAlarmInfoList) {
        return this.saveBatch(plcAlarmInfoList);
    }

    @Override
    public int delete(List<PlcAlarmInfo> plcAlarmInfoList) {
        return alarmMapper.deletePlcAlarmEntity();
    }
}
