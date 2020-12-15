package com.bgy.gateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bgy.gateway.model.dto.DataModelInfo;
import com.bgy.gateway.model.entity.ComponentEntity;
import com.bgy.gateway.model.entity.DataModelEntity;
import com.bgy.gateway.model.vo.DataModelVO;
import com.bgy.gateway.model.vo.EventVO;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/11/26 9:34
 */
public interface DataModelService extends IService<DataModelEntity> {
   /**
    * 获取数据模型实体
    * @param componentId
    * @return
    */
   DataModelEntity getDataModelEntity(Long componentId);
   /**
    * 获取多条数据模型
    * @param dataModelId
    * @return
    */
   List<DataModelVO> listDataModelEntity(Long dataModelId);

   /**
    * 获取地址监控值
    * @param componentId
    * @return
    */
   List<EventVO> listMonitorModel(Long componentId);

   /**
    * 批量插入
    * @param modelInfoList
    * @return
    */
   boolean saveBatch(List<DataModelInfo> modelInfoList);

   /**
    * 删除表
    * @param modelInfoList
    * @return
    */
   int delete(List<DataModelInfo> modelInfoList);
}
