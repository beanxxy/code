package com.bgy.gateway.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bgy.gateway.model.entity.PlcAlarmEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author caijunwei
 * date 2020/11/26 16:14
 */

@Mapper
public interface AlarmMapper extends BaseMapper<PlcAlarmEntity> {

    int deletePlcAlarmEntity();
}
