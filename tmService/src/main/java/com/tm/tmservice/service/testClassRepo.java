package com.tm.tmservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "TM-SERVICE", url = "192.168.100.162:8081")
public interface testClassRepo
{
    @RequestMapping(value="tm/hello3")
    String findServerInfo(@RequestParam("uid") String uid);
}
