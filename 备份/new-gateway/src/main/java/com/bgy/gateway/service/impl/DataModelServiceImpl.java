package com.bgy.gateway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgy.gateway.dao.mapper.DataModelMapper;
import com.bgy.gateway.model.dto.DataModelInfo;
import com.bgy.gateway.model.entity.DataModelEntity;
import com.bgy.gateway.model.vo.DataModelVO;
import com.bgy.gateway.model.vo.EventVO;
import com.bgy.gateway.service.DataModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author caijunwei
 * date 2020/11/26 9:34
 */
@Service
public class DataModelServiceImpl extends ServiceImpl<DataModelMapper, DataModelEntity> implements DataModelService {

    @Autowired
    DataModelMapper dataModelMapper;

    @Override
    public DataModelEntity getDataModelEntity(Long componentId) {
        return dataModelMapper.selectOne(new QueryWrapper<DataModelEntity>().eq("component_id", componentId));

    }

    @Override
    public List<DataModelVO> listDataModelEntity(Long dataModelId) {
        return dataModelMapper.listDataModelEntity(dataModelId);
    }

    @Override
    public List<EventVO> listMonitorModel(Long componentId) {
        return dataModelMapper.listMonitorModel(componentId);
    }

    @Override
    public boolean saveBatch(List<DataModelInfo> modelInfoList) {
        return this.saveBatch(modelInfoList);
    }

    @Override
    public int delete(List<DataModelInfo> modelInfoList) {
        return dataModelMapper.deleteDataModelEntity();
    }
}
