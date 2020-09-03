package com.makimenko.fs.persistence.repository;

import com.makimenko.fs.domain.book.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface AuthorRepository extends MongoRepository<Author, UUID> {

}
