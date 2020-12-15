package com.bgy.gateway.repository;

import com.bgy.gateway.model.entity.SysConfigEntity;
import com.bgy.gateway.service.SysConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author caijunwei
 * date 2020/12/3 16:20
 */
@Component
public class SysConfigRepository {

    private static final Logger logger = LoggerFactory.getLogger(SysConfigRepository.class);

    public static Map<String, String> SYS_CONFIGS = new HashMap<>();

    @Autowired
    private SysConfigService configService;

    @PostConstruct
    public void initConfigs() {
        logger.info("初始化系统参数...");
        List<SysConfigEntity> records = configService.list(null);
        if (records == null || records.isEmpty()) {
            return;
        }
        for (SysConfigEntity record : records) {
            SYS_CONFIGS.put(record.getConfigKey(), record.getConfigValue());
        }
    }

    @PreDestroy
    public void destroyConfigs() {
        if (SYS_CONFIGS != null) {
            SYS_CONFIGS.clear();
        }
    }

    public Optional<String> getConfig(String key) {
        return Optional.ofNullable(SYS_CONFIGS.get(key));
    }
}
