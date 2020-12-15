package com.bgy.gateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bgy.gateway.model.dto.ConfigVersionInfo;
import com.bgy.gateway.model.entity.ConfigVersionEntity;
import com.bgy.gateway.model.vo.ResultVO;

import java.util.List;

/**
 * @author caijunwei
 * date 2020/11/26 9:34
 */
public interface ConfigVersionService extends IService<ConfigVersionEntity> {

    /**
     * 获取PLC版本配置列表
     * @return
     */
    ResultVO listConfigVersionEntity(ConfigVersionEntity configVersionEntity);

    /**
     * 批量插入
     * @param versionInfoList
     * @return
     */
    boolean saveBatch(List<ConfigVersionInfo> versionInfoList);

    /**
     * 批量删除
     * @param versionInfoList
     * @return
     */
    int delete(List<ConfigVersionInfo> versionInfoList);
}
