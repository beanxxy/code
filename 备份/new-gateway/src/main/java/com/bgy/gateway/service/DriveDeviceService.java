package com.bgy.gateway.service;

import com.bgy.gateway.model.vo.ResultVO;

/**
 * @author caijunwei
 * date 2020/12/1 17:15
 */
public interface DriveDeviceService {

    /**
     * 封装数据
     * @param param
     * @return
     */
    ResultVO managerDevice(String param,int type);
}
