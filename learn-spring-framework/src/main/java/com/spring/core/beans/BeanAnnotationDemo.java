package com.spring.core.beans;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Student{
    private Address address;

    public Student(Address address) {
        this.address = address;
    }
    public void print(){
        System.out.println("student class method called ..");
        address.print();
    }

    public void init(){
        System.out.println("bean initialized ..");
    }

    public void destroy(){
        System.out.println("bean destroyed ..");
    }
}
class Address{
    public void print() {
        System.out.println("address class method called ..");
    }
}

@Configuration
class AppConfig{
    @Bean(name = "studentAddress")
    public Address address(){
        return new Address();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Student student(){
        return new Student(address());
    }
}
public class BeanAnnotationDemo {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(AppConfig.class)){
        // Student student = context.getBean(Student.class);
        Student student = (Student) context.getBean("student");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String bean: beanDefinitionNames){
            System.out.println(bean);
        }
        student.print();
//        Address address = context.getBean(Address.class);
//        address.print();
        }
    }
}
