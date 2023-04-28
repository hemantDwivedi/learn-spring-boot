package com.spring.core.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
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
