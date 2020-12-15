package com.bgy.gateway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgy.gateway.dao.mapper.MonitorMapper;
import com.bgy.gateway.model.dto.FunctionInfo;
import com.bgy.gateway.model.dto.MonitorInfo;
import com.bgy.gateway.model.entity.MonitorEntity;
import com.bgy.gateway.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/12/9 15:39
 */
@Service
public class MonitorServiceImpl extends ServiceImpl<MonitorMapper, MonitorEntity> implements MonitorService {

    @Autowired
    MonitorMapper monitorMapper;
    @Override
    public boolean saveBatch(List<MonitorInfo> monitorInfoList) {
        return this.saveBatch(monitorInfoList);
    }

    @Override
    public int delete(List<MonitorInfo> monitorInfoList) {
        return monitorMapper.deleteMonitorEntity();
    }


}
