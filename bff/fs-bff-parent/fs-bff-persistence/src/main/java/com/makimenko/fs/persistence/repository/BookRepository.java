package com.makimenko.fs.persistence.repository;

import com.makimenko.fs.common.domain.book.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepository extends MongoRepository<Book, Long> {

}
