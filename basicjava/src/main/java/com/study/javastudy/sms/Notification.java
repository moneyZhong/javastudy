package com.study.javastudy.sms;

import java.io.Serializable;
import java.util.Map;

public interface Notification extends Serializable {
    enum Type{
        Sms,
        Email,
        Push
    }

    /**
     * 通知全局唯一Id
     * @return
     */
    long getId();

    /**
     * 获取重试次数
     * @return
     */
    int getRetryCount();

    SmsMessage getSmsMessage();

    MailMessage getMailMessage();

    Map<String,Object> getCustom();

    Map<String,Object> getParams();
}
