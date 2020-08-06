package com.makimenko.fs.persistence.mongodb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "com.makimenko.fs.persistence.mongodb"
})
public class MongoDbConfig {
}
