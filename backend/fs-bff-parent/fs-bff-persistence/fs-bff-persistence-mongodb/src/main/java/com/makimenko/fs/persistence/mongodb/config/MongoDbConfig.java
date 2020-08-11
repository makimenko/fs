package com.makimenko.fs.persistence.mongodb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan({
        "com.makimenko.fs.persistence.mongodb"
})
@EnableMongoRepositories({"com.makimenko.fs.persistence.mongodb"})
public class MongoDbConfig {


}
