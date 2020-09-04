package com.makimenko.fs.web.service;

import com.makimenko.fs.web.config.WebConfig;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import(WebConfig.class)
public class TestConfig {

}