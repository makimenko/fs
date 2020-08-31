package com.makimenko.fs.persistence.dao;

import com.makimenko.fs.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookDaoMongoImpl implements BookDao {

    @Autowired
    public MongoTemplate mongoTemplate;

    private BookRepository bookRepository;

    public BookDaoMongoImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Is it required?

}
