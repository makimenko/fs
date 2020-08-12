package com.makimenko.fs.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EnableSwagger2
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    private static final String AZURE_API_NET = "https://";

    @Bean
    public Docket apiFs() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/api/.*"))
                .build()
                .groupName("FS")
                .protocols(Stream.of("https", "http").collect(Collectors.toSet()))
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfoFs())
                ;
    }

    private ApiInfo apiInfoFs() {
        return new ApiInfo(
                "FS - Web",
                "Full Stack Web Application",
                "1.0",
                "Terms of service",
                new Contact("TBD", AZURE_API_NET, "TBD"),
                "MIT",
                AZURE_API_NET, Collections.emptyList());
    }
}
