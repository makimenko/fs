package com.makimenko.fs.persistence.repository;

import com.makimenko.fs.domain.book.BookGenre;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public interface BookGenreRepository extends MongoRepository<BookGenre, String> {

    @Cacheable("BookGenre")
    @Override
    Optional<BookGenre> findById(String s);

    default <T, S> List<BookGenre> refDataList(List<String> list) {
        if (list != null) {
            return list.stream()
                    .map(id -> this.findById(id).orElse(null))
                    .filter(i -> i != null)
                    .collect(Collectors.toList());
        }
        return null;
    }

}
