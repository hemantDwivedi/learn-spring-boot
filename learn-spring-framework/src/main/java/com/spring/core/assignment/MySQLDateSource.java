package com.spring.core.assignment;

import org.springframework.stereotype.Component;

@Component
public class MySQLDateSource implements DataSource{

    String[] emails = {"hemant@gmail.com","hello@gmail.com", "world@gmail.com"};
    @Override
    public String[] getEmails() {
        return emails;
    }
}
