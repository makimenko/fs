package com.makimenko.fs.persistence.cache;

import com.makimenko.fs.domain.book.BookGenre;
import com.makimenko.fs.persistence.exception.DaoException;
import com.makimenko.fs.persistence.repository.BookGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class BookGenreCacheImpl implements BookGenreCache {

    @Autowired
    BookGenreRepository repo;

    @Cacheable("cachedBookGenre")
    @Override
    public BookGenre find(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new DaoException("BookGenre not found by id [" + id + "]"));
    }

}
