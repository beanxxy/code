package com.bgy.gateway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bgy.gateway.model.entity.Device;
import com.bgy.gateway.mapper.DeviceMapper;
import com.bgy.gateway.service.DeviceService;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
}
