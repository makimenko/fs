package com.makimenko.fs.web;

import com.makimenko.fs.persistence.config.MongoDbConfig;
import com.makimenko.fs.web.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {
        "com.makimenko.fs.web"
})
@Import({
        MongoDbConfig.class,
        SwaggerConfig.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
