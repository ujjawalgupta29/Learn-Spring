package com.example.learningspring;

import com.example.learningspring.game.GameRunner;
import com.example.learningspring.game.GamingConsole;
import com.example.learningspring.game.Pacman;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingBasicSpringBeans {
    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }


    }
}
