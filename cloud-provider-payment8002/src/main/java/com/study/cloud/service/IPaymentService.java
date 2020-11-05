package com.study.cloud.service;

import com.study.cloud.entity.Payment;

public interface IPaymentService {
    Integer insert(Payment payment);
    Payment getPaymentById(Long id);
}
