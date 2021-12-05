package com.oubin.spring_cloud_alibaba.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * MemberServiceFeign
 *
 * @Description: java类作用描述
 * @CreateDate: 2021/12/4 10:19 下午
 * @Version: 1.0
 * @Author: oubin
 */
@FeignClient("member")
public interface MemberServiceFeign {

    @GetMapping("/user")
    String getUser(@RequestParam("userId") String userId);
}
