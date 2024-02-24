package com.example.learningspring.examples.a2;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
class A {

}

@Component
@Lazy
class B {
    private A a;
    public B(A a) {
        System.out.println("Initilization");
        this.a = a;
    }

    public void fun() {
        System.out.println("fun exec");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
//            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("Initialization of context completed");;
            context.getBean(B.class).fun();
        }


    }
}
