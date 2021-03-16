package com.study.javastudy.sms;

import com.google.common.collect.Maps;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

public class NotificationBuilder {
    protected long id;
    protected int retryCount = 3;
    protected SmsMessage smsMessage ;
    protected MailMessage mailMessage;
    protected Map<String,Object> custom = Maps.newHashMap();
    protected Map<String,Object> params = Maps.newHashMap();

    private NotificationBuilder(long id){
        this.id = id;
    }

    public static NotificationBuilder builder(long id){
        return new NotificationBuilder(id);
    }



    private NotificationBuilder(NotificationBuilder builder){
        this.id = builder.id;
        this.retryCount = builder.retryCount;
        this.smsMessage = builder.smsMessage;
        this.mailMessage = builder.mailMessage;
        this.custom = builder.custom;
        this.params = builder.params;
    }

    public NotificationBuilder put(String key,Object value){
        this.params.put(key,value);
        return this;
    }

    public NotificationBuilder custom(String key,Object value){
        this.custom.put(key,value);
        return this;
    }

    public SmsConfigurer sms(){
        this.smsMessage = new SmsMessage();
        return new SmsConfigurer(this);
    }

    public static class SmsConfigurer extends NotificationBuilder{

        private SmsConfigurer(NotificationBuilder notificationBuilder){
            super(notificationBuilder);
        }

        public SmsConfigurer withRecivers(String... receivers){
            this.smsMessage.setReceivers(receivers);
            return this;
        }

        public SmsConfigurer witeMessage(String message){
            this.smsMessage.setMessage(message);
            return this;
        }


    }

    public Notification build(){
        if(this.mailMessage == null && this.smsMessage == null){
            throw new RuntimeException("no message specified");
        }
        if(this.smsMessage != null){
            this.smsMessage.validate();
            this.smsMessage.setMessage(render(this.smsMessage.getMessage(),this.params));
        }

        NotificationImpl notification = new NotificationImpl();

       /*
       没有get/set 这里用copy无效
       try {

            BeanUtils.copyProperties(notification, this);
        } catch (Exception e) {
           throw new RuntimeException("create notifcation fail");
        }*/
        notification.setId(this.id);
        notification.setCustom(this.custom);
        notification.setMailMessage(mailMessage);
        notification.setParams(this.params);
        notification.setRetryCount(retryCount);
        notification.setSmsMessage(smsMessage);
        return notification;
    }

    private String render(String template,Map<String,Object> params){
        if(template == null || params == null){
            return template;
        }
        VelocityContext context = new VelocityContext();
        for(String key : params.keySet()){
            context.put(key,params.get(key));
        }
        StringWriter writer = new StringWriter();
        Velocity.evaluate(context,writer,"render template",template);
        return writer.toString();
    }


}
