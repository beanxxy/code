package com.bgy.gateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bgy.gateway.model.dto.ComponentInfo;
import com.bgy.gateway.model.entity.ComponentEntity;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/11/26 9:34
 */
public interface ComponentService extends IService<ComponentEntity> {

   /**
    * 根据组件编号获取
    * @param componentCode
    * @return
    */
   ComponentEntity getComponentEntity(Integer componentCode);

   /**
    * 批量插入
    * @param componentInfoList
    * @return
    */
   boolean saveBatch(List<ComponentInfo> componentInfoList);

   /**
    * 批量删除
    * @param componentInfoList
    * @return
    */
   int delete(List<ComponentInfo> componentInfoList);
}
