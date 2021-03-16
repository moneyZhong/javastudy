package com.study.javastudy.sms;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.EmailValidator;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MailMessage implements Message, Serializable {
    private  String from;
    private String[] recivers;
    private String subject;
    private String message;
    private boolean html;
    @Override
    public void validate() {
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(recivers),"recivers must not be empty");
        Preconditions.checkArgument(StringUtils.isNotEmpty(from),"email from  must not be empty");
        Preconditions.checkArgument(StringUtils.isNotEmpty(subject),"email subject  must not be empty");
        Preconditions.checkArgument(StringUtils.isNotEmpty(message),"email message  must not be empty");

        ensureEmalValid();
        // 去重
        HashSet<String> uniqueRecivers = Sets.newHashSet(this.recivers);
        this.recivers = uniqueRecivers.toArray(new String[uniqueRecivers.size()]);
    }

    private void ensureEmalValid(){
        EmailValidator emailValidator = EmailValidator.getInstance();
        Set<String> notValidEmails = null;
        for (String email : this.recivers){
           if( emailValidator.isValid(email)){
               continue;
           }
           if(Objects.isNull(notValidEmails)){
               notValidEmails = new HashSet<>();
           }
            notValidEmails.add(email);
        }
        if(!Objects.isNull(notValidEmails)){
            throw new IllegalArgumentException("Email invalid:"+Arrays.toString(notValidEmails.toArray()));
        }
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getRecivers() {
        return recivers;
    }

    public void setRecivers(String[] recivers) {
        this.recivers = recivers;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isHtml() {
        return html;
    }

    public void setHtml(boolean html) {
        this.html = html;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MailMessage{" +
                "from='" + from + '\'' +
                ", receivers=" + Arrays.toString(recivers) +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", html=" + html +
                '}';
    }
}
