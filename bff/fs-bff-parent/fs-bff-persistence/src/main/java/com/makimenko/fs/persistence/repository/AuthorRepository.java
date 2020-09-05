package com.makimenko.fs.persistence.repository;

import com.makimenko.fs.domain.book.Author;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends MongoRepository<Author, ObjectId> {

    @Query(value = "{}", fields = "{id:1, name:1}")
    List<Author> findAuthorList();

}
