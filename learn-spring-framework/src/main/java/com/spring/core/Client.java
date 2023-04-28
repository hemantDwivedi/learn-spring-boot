package com.spring.core;

import com.spring.core.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {

        // creating IoC container
        // read configuration file
        // create and manage the spring beans
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve spring beans from spring IoC container
//        Car car = applicationContext.getBean(Car.class);
//        car.move();
//
//        Bus bus = applicationContext.getBean(Bus.class);
//        bus.move();
//
//        Bike bike = applicationContext.getBean(Bike.class);
//        bike.move();

        Traveler traveler = applicationContext.getBean(Traveler.class);
        traveler.startJourney();
    }
}
