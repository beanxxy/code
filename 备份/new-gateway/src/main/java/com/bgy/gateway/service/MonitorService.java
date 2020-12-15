package com.bgy.gateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bgy.gateway.model.dto.MonitorInfo;
import com.bgy.gateway.model.entity.MonitorEntity;

import java.util.List;


/**
 * @author caijunwei
 * date 2020/11/26 9:34
 */
public interface MonitorService extends IService<MonitorEntity> {

   /**
    * 批量插入
    * @param monitorInfoList
    * @return
    */
   boolean saveBatch(List<MonitorInfo> monitorInfoList);

   /**
    * 批量删除
    * @param monitorInfoList
    * @return
    */
   int delete(List<MonitorInfo> monitorInfoList);
}
