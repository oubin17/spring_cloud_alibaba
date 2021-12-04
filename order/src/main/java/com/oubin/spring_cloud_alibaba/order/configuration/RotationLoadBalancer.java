package com.oubin.spring_cloud_alibaba.order.configuration;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: RotationLoadBalancer
 * @Description: java类作用描述
 * @CreateDate: 2021/12/4 10:17 上午
 * @Version: 1.0
 * @Author: oubin
 */
@Component
public class RotationLoadBalancer implements LoadBalance {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance balance(List<ServiceInstance> serviceInstanceList) {
        int index = atomicInteger.incrementAndGet() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}
