package com.makimenko.fs.web;

import com.makimenko.fs.persistence.mongodb.config.MongoDbConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {
        // "com.makimenko.fs.persistence.mongodb.repository"
        "com.makimenko.fs.web"
})
@Import(MongoDbConfig.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
