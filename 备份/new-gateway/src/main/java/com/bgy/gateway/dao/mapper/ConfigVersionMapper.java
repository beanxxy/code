package com.bgy.gateway.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bgy.gateway.model.entity.ConfigVersionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/11/26 16:14
 */

@Mapper
public interface ConfigVersionMapper extends BaseMapper<ConfigVersionEntity> {

    List<ConfigVersionEntity> listConfigVersionEntity(ConfigVersionEntity configVersionEntity);

    int deleteConfigVersionEntity();
}
