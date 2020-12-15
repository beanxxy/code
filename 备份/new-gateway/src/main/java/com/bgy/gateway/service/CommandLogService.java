package com.bgy.gateway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bgy.gateway.model.entity.CommandLogEntity;


/**
 * @author caijunwei
 * date 2020/12/3 15:43
 */
public interface CommandLogService extends IService<CommandLogEntity> {
    /**
     * 保存信息对象
     *
     * @param record 信息对象
     * @return 影响记录数
     */
    int saveCommandLogEntity(CommandLogEntity record);


}
