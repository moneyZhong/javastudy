package com.study.javastudy.sms;

import java.util.Random;
import java.util.UUID;

public class NotificationTemplate {
    public void execute(NotificationCallback notificationCallback){
        //封装msg公共参数
        Notification notification = notificationCallback.execute(NotificationBuilder.builder(new Random().nextInt()));
        //发送消息
        System.out.println("发送消息:"+notification.getSmsMessage().getMessage());
        
    }
}
