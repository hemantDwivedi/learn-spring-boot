package com.spring.core.assignment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PostgreSQLDataSource implements DataSource{
    String[] emails = {"new@gmail.com","old@gmail.com", "present@gmail.com"};
    @Override
    public String[] getEmails() {
        return emails;
    }
}
