package com.study.cloud.service.impl;

import com.study.cloud.dao.PaymentDao;
import com.study.cloud.entity.Payment;
import com.study.cloud.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private PaymentDao paymentDao;

    public Integer insert(Payment payment) {
        return paymentDao.insert(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
