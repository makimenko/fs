package com.makimenko.fs.persistence.repository;

import com.makimenko.fs.domain.book.BookGenre;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookGenreRepository extends MongoRepository<BookGenre, String> {

    String CACHE_ID = "BookGenreRepository";

    @Cacheable(CACHE_ID)
    @Override
    Optional<BookGenre> findById(String s);

}
