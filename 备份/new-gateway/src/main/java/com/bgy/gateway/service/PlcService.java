package com.bgy.gateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bgy.gateway.model.dto.PlcInfo;
import com.bgy.gateway.model.entity.PlcEntity;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/11/26 9:34
 */
public interface PlcService extends IService<PlcEntity> {

   /**
    * 根据plcID获取
    * @param plcId
    * @return
    */
   PlcEntity getPlcEntity(Long plcId);

   /**
    * 批量插入
    * @param plcInfoList
    * @return
    */
   boolean saveBatch(List<PlcInfo> plcInfoList);

   /**
    * 删除
    * @param plcInfoList
    * @return
    */
   int delete(List<PlcInfo> plcInfoList);
}
