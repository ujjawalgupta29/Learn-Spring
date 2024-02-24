package com.example.learningspring.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("superContraGameQualifier")
public class SuperContra implements GamingConsole {
    public void up() {
        System.out.println("Jump");
    }

    public void down() {
        System.out.println("sit down");
    }

    public void left() {
        System.out.println("back");
    }

    public void right() {
        System.out.println("shoot");
    }
}
