package com.example.learningspring;

import com.example.learningspring.game.GameRunner;
import com.example.learningspring.game.GamingConsole;
import com.example.learningspring.game.Pacman;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game() {
        return new Pacman();
    }

    @Bean
    public GameRunner gameRunner  (GamingConsole game) {
        return new GameRunner(game);
    }

}
