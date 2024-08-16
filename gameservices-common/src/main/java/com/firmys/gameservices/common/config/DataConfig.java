package com.firmys.gameservices.common.config;

import com.firmys.gameservices.common.CommonConstants;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
@Profile(CommonConstants.PROFILE_DATA)
public class DataConfig extends AbstractReactiveMongoConfiguration {

  @Value("${gameservices.current.id}")
  private String dataBaseName;

  @Override
  protected @NotNull String getDatabaseName() {
    return dataBaseName;
  }

  @Bean
  @Override
  public @NotNull MongoClient reactiveMongoClient() {
    return MongoClients.create("mongodb://root:mongopw@localhost:27017");
  }

  @Bean
  public ReactiveMongoTemplate reactiveMongoTemplate() {
    return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
  }
}
