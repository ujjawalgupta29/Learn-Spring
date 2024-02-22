package com.example.learningspring.game;

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
