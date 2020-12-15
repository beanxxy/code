package com.bgy.gateway.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bgy.gateway.model.entity.ComponentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author caijunwei
 * date 2020/11/26 16:14
 */

@Mapper
public interface ComponentMapper extends BaseMapper<ComponentEntity> {

    int deleteComponentEntity();
}
