package com.study.cloud.controller;

import com.study.cloud.entity.CommResult;
import com.study.cloud.entity.Payment;
import com.study.cloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private IPaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @RequestMapping("getPort")
    public String getPort(){
        return port;
    }
    @GetMapping("/getById/{id}")
    public CommResult<Payment> getById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("======343434==查询{}",id);
        if(payment == null){
            return new CommResult(-1,"不存在");
        }else{
            return new CommResult<Payment>(0,"成功",payment);
        }

    }


}
