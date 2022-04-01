package com.firmys.gameservice.characters;

import com.firmys.gameservice.common.config.GameServiceCommonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
@Import(GameServiceCommonConfig.class)
public class CharacterApp {
    public static void main(String[] args) {
        SpringApplication.run(CharacterApp.class, args);
    }
}