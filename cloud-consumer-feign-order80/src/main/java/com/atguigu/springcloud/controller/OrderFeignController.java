package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping(value = "consumer/payment/getServerPort/{id}")
    public CommonResult<String> getServerPort(@PathVariable("id") Long id){
         String serverPort = paymentFeignService.getServerPort(id);
         return new CommonResult<>(serverPort);
    }
}
