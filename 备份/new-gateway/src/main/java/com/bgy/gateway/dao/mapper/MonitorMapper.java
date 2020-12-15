package com.bgy.gateway.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bgy.gateway.model.entity.MonitorEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author caijunwei
 * date 2020/11/26 16:14
 */

@Mapper
public interface MonitorMapper extends BaseMapper<MonitorEntity> {


    int deleteMonitorEntity();
}
