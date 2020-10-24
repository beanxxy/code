package com.bgy.gateway.service.store;

import com.bgy.gateway.model.dto.steam.SteamSelfFastFoodOutDto;
import com.bgy.gateway.model.vo.ResultVo;

/**
 * @author lzx
 * @date 2020/3/19.
 */
public interface FastFoodSteamSlefService {
    /**
     * 自助式整箱发送出料指令
     *
     * @param steamSelfFastFoodOutDto
     * @return
     */
    ResultVo sendSteamSelfFastFoodOut(SteamSelfFastFoodOutDto steamSelfFastFoodOutDto);
}
