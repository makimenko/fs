package com.makimenko.fs.persistence.mongodb.repository;

import com.makimenko.fs.persistence.mongodb.entity.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepository extends MongoRepository<BookEntity, Long> {

}
