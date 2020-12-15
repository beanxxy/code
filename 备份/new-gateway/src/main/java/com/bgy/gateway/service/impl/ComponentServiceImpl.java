package com.bgy.gateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgy.gateway.dao.mapper.ComponentMapper;
import com.bgy.gateway.model.dto.ComponentInfo;
import com.bgy.gateway.model.entity.ComponentEntity;
import com.bgy.gateway.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author caijunwei
 * date 2020/11/26 9:34
 */
@Service
public class ComponentServiceImpl extends ServiceImpl<ComponentMapper, ComponentEntity> implements ComponentService {

    @Autowired
    ComponentMapper componentMapper;

    @Override
    public ComponentEntity getComponentEntity(Integer componentCode) {
        return componentMapper.selectOne(new QueryWrapper<ComponentEntity>().eq("code", componentCode));
    }

    @Override
    public boolean saveBatch(List<ComponentInfo> componentInfoList) {
        return this.saveBatch(componentInfoList);
    }

    @Override
    public int delete(List<ComponentInfo> componentInfoList) {
        return componentMapper.deleteComponentEntity();
    }
}
