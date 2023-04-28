package com.springboot.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

//	@Bean
//	public Hello hello(){
//		return new Hello();
//	}
	public static void main(String[] args) {
//		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//		Hello hello = context.getBean(Hello.class);
//		System.out.println(hello.message());
		SpringApplication.run(Application.class, args);
	}

}
