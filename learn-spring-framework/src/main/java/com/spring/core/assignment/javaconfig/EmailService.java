package com.spring.core.assignment.javaconfig;

import org.springframework.stereotype.Component;

public class EmailService {
    private final DataSource dataSource;
    public EmailService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void sendEmail(){
        String[] emails = dataSource.getEmails();
        for(String email: emails){
            System.out.println(email);
        }
    }
}
