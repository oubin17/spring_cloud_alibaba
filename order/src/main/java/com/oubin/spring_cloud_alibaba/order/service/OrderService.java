package com.oubin.spring_cloud_alibaba.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: OrderService
 * @Description: java类作用描述
 * @CreateDate: 2021/12/4 9:17 上午
 * @Version: 1.0
 * @Author: oubin
 */
@RestController
public class OrderService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/order")
    public Object orderToMember() {

        List<ServiceInstance> instances = discoveryClient.getInstances("member");
        return instances.get(0);

    }
}
