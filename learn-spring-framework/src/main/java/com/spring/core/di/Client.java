package com.spring.core.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {

        String message = "hello spring";
        // SmsService smsService = new SmsService();
        // MessageSender messageSender = new MessageSender(smsService);
        // messageSender.sendMessage(message);

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageSender sender = context.getBean(MessageSender.class);
        sender.sendMessage(message);
    }
}
