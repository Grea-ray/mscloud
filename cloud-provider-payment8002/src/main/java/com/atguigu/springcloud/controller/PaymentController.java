package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        if(i<0){
            log.info("查询失败");
            return new CommonResult(400,"插入数据失败aaa");
        }else{
            return new CommonResult(200,"插入数据成功agfd"+"\t 服务端口："+serverPort);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果:{}",payment);
        if (payment != null) {
            log.info("查询失败");
            return new CommonResult(200,"查询成功"+"\t 服务端口："+serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID: "+id,null);
        }
    }


    @GetMapping(value = "/payment/getServerPort/{id}")
    public String getServerPort(@PathVariable("id") Long id){
        /*try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return this.serverPort;
    }
}
