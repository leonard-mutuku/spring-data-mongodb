/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mongodb.config;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.model.User;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;

/**
 *
 * @author leonard
 */
//This configuration class could be used in place of apllication properties configs (spring.data.mongodb.*) and application will work well if its commented out
@Configuration
public class MongoConfig {

    @Autowired
    private ApplicationProperties props;

    public @Bean
    MongoClient mongoClient() {
        String conn = props.getUri() + ":" + props.getPort() + "/" + props.getDatabase() + "?authSource=" + props.getAuthenticationDatabase();
        MongoClient mongoClient = MongoClients.create(new ConnectionString(conn));

        return mongoClient;
    }

    public @Bean
    MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient(), props.getDatabase());

        TimeUnit timeUnit = getTimeUnit(props.getDocumentExpiryUnit());
        mongoTemplate.indexOps(User.class).ensureIndex(
                new Index().on("name", Sort.Direction.DESC).named("name_index")
        );
        mongoTemplate.indexOps(User.class).ensureIndex(
                new Index().on("expire", Sort.Direction.ASC).named("expiration_after_index").expire(props.getDocumentExpiry(), timeUnit)
        );

        return mongoTemplate;
    }

    private TimeUnit getTimeUnit(String unit) {
        return switch (unit) {
            case "d" -> TimeUnit.DAYS;
            case "h" -> TimeUnit.HOURS;
            case "m" -> TimeUnit.MINUTES;
            default -> TimeUnit.SECONDS;
        };
    }

//    @Override
//    public boolean autoIndexCreation() {
//      return true;
//    }
}
