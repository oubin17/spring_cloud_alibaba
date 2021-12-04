package com.oubin.spring_cloud_alibaba.order.configuration;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ClassName: LoadBalance
 * @Description: java类作用描述
 * @CreateDate: 2021/12/4 10:18 上午
 * @Version: 1.0
 * @Author: oubin
 */
public interface LoadBalance {

    /**
     * 负载均衡算法
     *
     * @param serviceInstanceList
     * @return
     */
    ServiceInstance balance(List<ServiceInstance> serviceInstanceList);
}
