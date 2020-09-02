package com.makimenko.fs.persistence.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan({
        "com.makimenko.fs.persistence"
})
@EnableMongoRepositories({"com.makimenko.fs.persistence.repository"})
@Import({CacheConfig.class})
public class MongoDbConfig {

}
