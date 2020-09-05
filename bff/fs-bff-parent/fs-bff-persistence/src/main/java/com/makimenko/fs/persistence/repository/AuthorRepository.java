package com.makimenko.fs.persistence.repository;

import com.makimenko.fs.domain.book.Author;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface AuthorRepository extends MongoRepository<Author, ObjectId> {

}
