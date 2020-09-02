package com.makimenko.fs.persistence.repository;

import com.makimenko.fs.domain.book.BookGenre;
import com.makimenko.fs.persistence.cache.CachedRefDataRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookGenreRepository extends CachedRefDataRepository<BookGenre> {

}
