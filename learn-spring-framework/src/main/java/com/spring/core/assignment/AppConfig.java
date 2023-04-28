package com.spring.core.assignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring.core.assignment")
public class AppConfig {

//    @Bean
//    public EmailService emailService(){
//        return new EmailService(dataSource());
//    }
//
//    @Bean
//    public DataSource dataSource(){
//        return new PostgreSQLDataSource();
//    }
}
