package com.oubin.spring_cloud_alibaba.order.service;

import com.oubin.spring_cloud_alibaba.order.configuration.LoadBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalance loadBalance;
    @GetMapping("/order")
    public Object orderToMember() {

        List<ServiceInstance> instances = discoveryClient.getInstances("member");
        ServiceInstance balance = loadBalance.balance(instances);
        String result = restTemplate.getForObject(balance.getUri() + "/user", String.class);
        return "从nacos获取到的生产者地址:" + balance.getUri() + " 获取到的userName: " + result;

    }
}
