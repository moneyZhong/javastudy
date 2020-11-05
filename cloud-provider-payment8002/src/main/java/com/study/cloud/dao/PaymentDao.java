package com.study.cloud.dao;

import com.study.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    Integer insert(Payment payment);
    Payment getPaymentById(Long id);
}
