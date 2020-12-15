package com.bgy.gateway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgy.gateway.dao.mapper.ConfigVersionMapper;
import com.bgy.gateway.model.dto.ConfigVersionInfo;
import com.bgy.gateway.model.entity.ConfigVersionEntity;
import com.bgy.gateway.model.vo.ResultVO;
import com.bgy.gateway.service.ConfigVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author caijunwei
 * date 2020/11/26 9:34
 */
@Service
public class ConfigVersionServiceImpl extends ServiceImpl<ConfigVersionMapper, ConfigVersionEntity> implements ConfigVersionService {

    @Autowired
    ConfigVersionMapper configVersionMapper;

    @Override
    public ResultVO listConfigVersionEntity(ConfigVersionEntity configVersionEntity) {
        return ResultVO.success(configVersionMapper.listConfigVersionEntity(configVersionEntity));
    }

    @Override
    public boolean saveBatch(List<ConfigVersionInfo> versionInfoList) {
        return this.saveBatch(versionInfoList);
    }

    @Override
    public int delete(List<ConfigVersionInfo> versionInfoList) {
        return configVersionMapper.deleteConfigVersionEntity();
    }
}
