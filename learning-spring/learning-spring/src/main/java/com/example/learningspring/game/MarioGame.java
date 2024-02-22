package com.example.learningspring.game;

public class MarioGame implements GamingConsole{
    public void up() {
        System.out.println("Jump");
    }

    public void down() {
        System.out.println("in hole");
    }

    public void left() {
        System.out.println("back");
    }

    public void right() {
        System.out.println("accelerate");
    }

}
