package com.oubin.spring_cloud_alibaba.order.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * DynamicConfig
 *
 * @Description:
 * @CreateDate: 2021/12/5 11:10 上午
 * @Version: 1.0
 * @Author: oubin
 */
@RefreshScope
@Component
public class DynamicConfig {

    @Value("${distribute.config.name}")
    private String value;

    private ApplicationContext applicationContext;

    public String getConfigByPath(String configPath) {
        return applicationContext.getEnvironment().getProperty(configPath);
    }

    public String getValue() {
        return value;
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
