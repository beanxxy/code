package com.bgy.gateway.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bgy.gateway.model.entity.DataModelEntity;
import com.bgy.gateway.model.vo.DataModelVO;
import com.bgy.gateway.model.vo.EventVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/11/26 16:14
 */

@Mapper
public interface DataModelMapper extends BaseMapper<DataModelEntity> {

    List<DataModelVO> listDataModelEntity(@Param("id") Long dataModelId);

    List<EventVO> listMonitorModel(@Param("componentId") Long componentId);

    int deleteDataModelEntity();
}
