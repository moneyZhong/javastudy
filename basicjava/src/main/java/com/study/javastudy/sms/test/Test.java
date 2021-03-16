package com.study.javastudy.sms.test;

import com.study.javastudy.sms.Notification;
import com.study.javastudy.sms.NotificationBuilder;
import com.study.javastudy.sms.NotificationCallback;
import com.study.javastudy.sms.NotificationTemplate;

public class Test {
    @org.junit.Test
    public void testSms(){
        NotificationTemplate notificationTemplate = new NotificationTemplate();
        notificationTemplate.execute(
                new NotificationCallback() {
                    @Override
                    public Notification execute(NotificationBuilder notificationBuilder) {
//                        return notificationBuilder.builder();
                        return notificationBuilder.sms().withRecivers("adsfas").witeMessage("template.tender.sms.limit")
                                .put("orgCode","1111").build();
                    }
                }
        );
    }
}
