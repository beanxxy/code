package com.bgy.gateway.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bgy.gateway.model.entity.ConfigVersionEntity;
import com.bgy.gateway.model.entity.PlcEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/11/26 16:14
 */

@Mapper
public interface PlcMapper extends BaseMapper<PlcEntity> {

    PlcEntity getPlcEntity(@Param("plcId") Long plcId);

    int deletePlcEntity();
}
