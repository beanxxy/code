package com.bgy.gateway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgy.gateway.dao.mapper.CommandLogMapper;
import com.bgy.gateway.model.entity.CommandLogEntity;
import com.bgy.gateway.service.CommandLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author caijunwei
 * date 2020/12/3 15:43
 */
@Service
public class CommandLogServiceImpl extends ServiceImpl<CommandLogMapper, CommandLogEntity> implements CommandLogService {

    @Autowired
    CommandLogMapper commandLogMapper;
    @Override
    public int saveCommandLogEntity(CommandLogEntity commandLogEntity) {
        return commandLogMapper.insert(commandLogEntity);
    }
}
