package com.firmys.gameservices.gateway;

import com.firmys.gameservices.common.CommonConstants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
@OpenAPIDefinition(
    info =
        @Info(
            title = CommonConstants.GAME_SERVICES_GATEWAY,
            version = CommonConstants.VERSION,
            description = "Game Services API"))
public class GatewayApplication {

  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(GatewayApplication.class);
    application.run(args);
  }
}
