package com.study.javastudy.sms;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Arrays;

public class SmsMessage implements Message, Serializable {

    private String[] receivers;

    private String message;


    @Override
    public void validate() {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(receivers),"recivers must not be empty");
        Preconditions.checkArgument(StringUtils.isNotEmpty(message),"message must not be empty");
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getReceivers() {
        return receivers;
    }

    public void setReceivers(String[] receivers) {
        this.receivers = receivers;
    }

    @Override
    public String toString() {
        return "SmsMessage{" +
                "receivers=" + Arrays.toString(receivers) +
                ", message='" + message + '\'' +
                '}';
    }
}
