package com.example.learningspring.examples.a4;

import java.util.Arrays;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class SomeClass {
    private SomeDep someDep;

    public SomeClass(SomeDep someDep) {
        this.someDep = someDep;
        System.out.println("All dep are ready");
    }

    @PostConstruct
    public void initialize() {
        someDep.getReady();
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Cleanup db conn");
    }
}

@Component
class SomeDep {

    public void getReady() {
        System.out.println("Some init logic");
    }
}

@Configuration
@ComponentScan
public class PrePostAnootationLauncherApplication {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(PrePostAnootationLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }


    }
}
