package com.example.learningspring;

import com.example.learningspring.game.GameRunner;
import com.example.learningspring.game.Pacman;

public class App01GamingBasic {
    public static void main(String[] args) {
        var game = new Pacman();
        var gameRunner = new GameRunner(game );

        gameRunner.run();
    }
}
