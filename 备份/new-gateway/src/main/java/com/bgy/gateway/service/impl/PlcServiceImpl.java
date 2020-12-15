package com.bgy.gateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgy.gateway.dao.mapper.PlcMapper;
import com.bgy.gateway.model.dto.PlcInfo;
import com.bgy.gateway.model.entity.PlcEntity;
import com.bgy.gateway.service.PlcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * @author caijunwei
 * date 2020/11/26 9:34
 */
@Service
public class PlcServiceImpl extends ServiceImpl<PlcMapper, PlcEntity> implements PlcService {

    @Autowired
    PlcMapper plcMapper;

    @Override
    public PlcEntity getPlcEntity(Long plcId) {
        return plcMapper.getPlcEntity(plcId);
    }

    @Override
    public boolean saveBatch(List<PlcInfo> plcInfoList) {
        return this.saveBatch(plcInfoList);
    }

    @Override
    public int delete(List<PlcInfo> plcInfoList) {
        return plcMapper.deletePlcEntity();
    }

}
