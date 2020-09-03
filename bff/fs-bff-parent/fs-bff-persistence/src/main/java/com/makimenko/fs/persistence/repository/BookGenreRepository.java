package com.makimenko.fs.persistence.repository;

import com.makimenko.fs.domain.book.BookGenre;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface BookGenreRepository extends MongoRepository<BookGenre, String> {

    String CACHE_ID = "BookGenreRepository";

    @Cacheable(CACHE_ID)
    @Override
    Optional<BookGenre> findById(String s);

}