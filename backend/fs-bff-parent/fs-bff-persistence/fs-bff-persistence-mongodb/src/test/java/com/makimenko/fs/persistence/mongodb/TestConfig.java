package com.makimenko.fs.persistence.mongodb;

import com.makimenko.fs.common.dao.BookDao;
import com.makimenko.fs.persistence.mongodb.config.MongoDbConfig;
import com.makimenko.fs.persistence.mongodb.dao.BookDaoMongoImpl;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@ComponentScan({
        "com.makimenko.fs.persistence.mongodb"
})
public class TestConfig {


}
