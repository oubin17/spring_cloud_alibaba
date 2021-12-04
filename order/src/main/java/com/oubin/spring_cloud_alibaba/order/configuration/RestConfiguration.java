package com.oubin.spring_cloud_alibaba.order.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: RestConfiguration
 * @Description: java类作用描述
 * @CreateDate: 2021/12/4 9:55 上午
 * @Version: 1.0
 * @Author: oubin
 */
@Configuration
public class RestConfiguration {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
