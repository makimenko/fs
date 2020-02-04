package com.makimenko.fs.bff.repository;

import com.makimenko.fs.bff.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Long> {


}
