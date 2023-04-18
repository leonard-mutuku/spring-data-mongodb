package com.mongodb;

import com.mongodb.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MongodbApplication {

    public static void main(String[] args) {
//		SpringApplication.run(MongodbApplication.class, args);
        final ApplicationContext ctx = SpringApplication.run(MongodbApplication.class, args);
        final ApplicationProperties confs = ctx.getBean(ApplicationProperties.class);
        System.out.println("configs:\n" + confs.toString());
    }

}
