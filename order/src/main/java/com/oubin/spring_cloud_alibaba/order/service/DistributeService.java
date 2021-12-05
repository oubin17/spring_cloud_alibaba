package com.oubin.spring_cloud_alibaba.order.service;

import com.oubin.spring_cloud_alibaba.order.configuration.DynamicConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * DistributeService
 *
 * @Description:
 * @CreateDate: 2021/12/5 10:12 上午
 * @Version: 1.0
 * @Author: oubin
 */
@RestController
@RefreshScope
public class DistributeService {

    private DynamicConfig dynamicConfig;

    @GetMapping("/distribute")
    public String getDistributeValue(@RequestParam("path") String configPath) {
        return this.dynamicConfig.getConfigByPath(configPath);
    }

    @Autowired
    public void setDynamicConfig(DynamicConfig dynamicConfig) {
        this.dynamicConfig = dynamicConfig;
    }
}
