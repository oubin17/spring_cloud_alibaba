package com.oubin.spring_cloud_alibaba.order.service;

import com.oubin.spring_cloud_alibaba.order.configuration.LoadBalance;
import com.oubin.spring_cloud_alibaba.order.feign.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate;

    private LoadBalance loadBalance;

    private LoadBalancerClient loadBalancerClient;

    private MemberServiceFeign memberServiceFeign;

    /**
     * 本地自定义负载均衡
     *
     * @return
     */
    @GetMapping("/order")
    public String orderToMember() {

        List<ServiceInstance> instances = discoveryClient.getInstances("member");
        ServiceInstance balance = loadBalance.balance(instances);
        String result = restTemplate.getForObject(balance.getUri() + "/user?userId=123", String.class);
        return "从nacos获取到的生产者地址:" + balance.getUri() + " 获取到的userName: " + result;

    }

    /**
     * ribbon负载均衡
     *
     * @return
     */
    @GetMapping("order/ribbon")
    public String ribbonOrder() {
        String result = restTemplate.getForObject("http://member" + "/user?userId=123", String.class);
        return "获取到的userName: " + result;
    }

    /**
     * loadbalancerClient实现负载均衡
     *
     * @return
     */
    @GetMapping("order/client")
    public String clientOrder() {
        ServiceInstance member = loadBalancerClient.choose("member");
        return "从nacos获取到的生产者地址:" + member.getUri();
    }

    @GetMapping("/order/feign")
    public String feignOrder() {
        String user = memberServiceFeign.getUser("123");
        return "通过feign获取到的用户名称" + user;
    }

    @Autowired
    public void setDiscoveryClient(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setLoadBalance(LoadBalance loadBalance) {
        this.loadBalance = loadBalance;
    }

    @Autowired
    public void setLoadBalancerClient(LoadBalancerClient loadBalancerClient) {
        this.loadBalancerClient = loadBalancerClient;
    }

    @Autowired
    public void setMemberServiceFeign(MemberServiceFeign memberServiceFeign) {
        this.memberServiceFeign = memberServiceFeign;
    }
}
