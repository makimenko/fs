package com.makimenko.fs.bff.dao.mongodb;

import com.makimenko.fs.bff.dao.mongodb.entity.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepository extends MongoRepository<BookEntity, Long> {


}
