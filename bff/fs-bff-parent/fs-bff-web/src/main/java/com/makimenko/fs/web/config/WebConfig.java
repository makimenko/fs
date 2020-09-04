package com.makimenko.fs.web.config;

import com.makimenko.fs.persistence.config.MongoDbConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        MongoDbConfig.class,
        SwaggerConfig.class
})
@ComponentScan("com.makimenko.fs.web")
public class WebConfig {
}
