package com.spring.core.di;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("smsService")
public class SmsService implements MessageService{

    @Override
    public void sendMessage(String message){
        System.out.println(message);
    }
}
