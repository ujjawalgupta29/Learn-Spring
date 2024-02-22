package com.example.learningspring.helloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
//        1. Launch a spring context
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
//        2. Configure things that we want spring to manage - @Configuration

//        3. Retrieving Beans managed by Spring
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("person2"));

        System.out.println(context.getBean("person3Parameters"));
//        System.out.println(context.getBean("address")); //error
        System.out.println(context.getBean("address2"));
        //different way
        System.out.println(context.getBean(Address.class)); //will give error if there are more than one bean of same type Address in this case


    }
}
