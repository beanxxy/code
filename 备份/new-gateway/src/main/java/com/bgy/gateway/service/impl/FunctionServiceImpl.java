package com.bgy.gateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgy.gateway.dao.mapper.FunctionMapper;
import com.bgy.gateway.model.dto.FunctionInfo;
import com.bgy.gateway.model.entity.FunctionEntity;
import com.bgy.gateway.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author caijunwei
 * date 2020/11/26 9:34
 */
@Service
public class FunctionServiceImpl extends ServiceImpl<FunctionMapper, FunctionEntity> implements FunctionService {

    @Autowired
    FunctionMapper functionMapper;


    @Override
    public FunctionEntity getFunctionEntity(Long componentId, Integer functionCode) {
        return functionMapper.selectOne(new QueryWrapper<FunctionEntity>().eq("component_id", componentId).eq("code",functionCode));
    }

    @Override
    public boolean saveBatch(List<FunctionInfo> functionInfoList) {
        return this.saveBatch(functionInfoList);
    }

    @Override
    public int delete(List<FunctionInfo> functionInfoList) {
        return functionMapper.deleteFunctionEntity();
    }
}
