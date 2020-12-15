package com.bgy.gateway.service;

import com.bgy.gateway.exception.BusinessException;
import com.bgy.gateway.model.vo.ResultVO;

/**
 * @author caijunwei
 * date 2020/12/9 10:01
 */
public interface SyncDataService {

    /**
     * 同步数据
     * @param data
     * @return
     */
    ResultVO syncData(String data) throws BusinessException;
}
