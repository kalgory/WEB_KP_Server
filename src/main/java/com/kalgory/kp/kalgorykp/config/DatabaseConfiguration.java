package com.kalgory.kp.kalgorykp.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * MongoDB 설정.
 */
@Configuration
@PropertySource("classpath:application-secure.properties")
public class DatabaseConfiguration {

  @Value("${spring.data.mongodb.uri}")
  private String mongodbUri;

  /**
   * MongoTemplate 설정.
   *
   * @return MongoTemplate 객체 반환.
   */
  @Bean
  public MongoTemplate mongoTemplate() {
    MongoClient mongoClient = MongoClients.create(mongodbUri);
    MongoDatabaseFactory mongoDatabaseFactory = new SimpleMongoClientDatabaseFactory(mongoClient,
        "kalgoryproblem");

    DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDatabaseFactory);
    MongoMappingContext mongoMappingContext = new MongoMappingContext();

    MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
    converter.setTypeMapper(new DefaultMongoTypeMapper(null));

    return new MongoTemplate(mongoDatabaseFactory, converter);
  }
}
