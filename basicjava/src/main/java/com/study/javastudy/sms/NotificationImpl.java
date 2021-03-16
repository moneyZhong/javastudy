package com.study.javastudy.sms;

import java.util.Map;

public class NotificationImpl implements  Notification{
    private long id;
    private int retryCount;
    private SmsMessage smsMessage;
    private MailMessage mailMessage;
    private Map<String,Object> custom;
    private Map<String,Object> params;

    @Override
    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public int getRetryCount() {
        return this.retryCount;
    }

    @Override
    public SmsMessage getSmsMessage() {
        return this.smsMessage;
    }

    @Override
    public MailMessage getMailMessage() {
        return this.mailMessage;
    }

    @Override
    public Map<String, Object> getCustom() {
        return this.custom;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public void setSmsMessage(SmsMessage smsMessage) {
        this.smsMessage = smsMessage;
    }

    public void setMailMessage(MailMessage mailMessage) {
        this.mailMessage = mailMessage;
    }

    public void setCustom(Map<String, Object> custom) {
        this.custom = custom;
    }


}
