package com.bgy.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfig {
    public static boolean IS_WARNING_INFO_REAL_LONG;
    public static boolean IS_READ_SHORT;

    @Autowired(required = false)
    public void isWarningInfoRealLong(@Value("${gateway.is-warning-info-real-long}") boolean isWarningInfoRealLong) {
        SystemConfig.IS_WARNING_INFO_REAL_LONG = isWarningInfoRealLong;
    }
    @Autowired(required = false)
    public void isReadShort(@Value("${gateway.is-read-short}") boolean isReadShort) {
        SystemConfig.IS_READ_SHORT = isReadShort;
    }

}
