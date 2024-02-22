package com.example.learningspring.helloWorld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age, Address address) {};
record Address (String city, int postalCode) {};

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name() {
        return "Ujjawal";
    }

    @Bean
    public int age() {
        return  24;
    }

    @Bean
    public Person person() {
        return new Person("Akshay", 30, new Address("jpr", 302017));
    }

    @Bean
    public Person person2() {
        return new Person(name(), age(), address()); //namer, age beans
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address2) {
        return new Person(name, age, address2); //namer, age beans
    }

    @Bean(name = "address2")
    public Address address() {
        return new Address("hyd", 500081);
    }
}
