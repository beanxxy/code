package com.bgy.gateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bgy.gateway.model.dto.FunctionInfo;
import com.bgy.gateway.model.entity.FunctionEntity;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/11/26 9:34
 */
public interface FunctionService extends IService<FunctionEntity> {

   /**
    * 获取方法实体
    * @param componentId
    * @param functionCode
    * @return
    */
   FunctionEntity getFunctionEntity(Long componentId,Integer functionCode);

   /**
    * 批量删除
    * @param functionInfoList
    * @return
    */
   boolean saveBatch(List<FunctionInfo> functionInfoList);

   /**
    * 批量删除
    * @param functionInfoList
    * @return
    */
   int delete(List<FunctionInfo> functionInfoList);
}
