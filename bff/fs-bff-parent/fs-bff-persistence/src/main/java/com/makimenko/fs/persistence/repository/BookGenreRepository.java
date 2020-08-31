package com.makimenko.fs.persistence.repository;

import com.makimenko.fs.domain.book.BookGenre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface BookGenreRepository extends MongoRepository<BookGenre, UUID> {

}
