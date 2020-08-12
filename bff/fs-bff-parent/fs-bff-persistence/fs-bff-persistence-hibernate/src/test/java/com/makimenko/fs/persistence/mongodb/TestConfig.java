package com.makimenko.fs.persistence.mongodb;

import com.makimenko.fs.persistence.mongodb.config.MongoDbConfig;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import(MongoDbConfig.class)
public class TestConfig {

}