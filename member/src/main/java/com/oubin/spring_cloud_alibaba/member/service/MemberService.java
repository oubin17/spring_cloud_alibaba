package com.oubin.spring_cloud_alibaba.member.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: MemberService
 * @Description: java类作用描述
 * @CreateDate: 2021/12/4 8:52 上午
 * @Version: 1.0
 * @Author: oubin
 */
@RestController
public class MemberService {
    
    @GetMapping("/user")
    public String getUser(@RequestParam("userId") String userId) {
        return userId;
    }
}
