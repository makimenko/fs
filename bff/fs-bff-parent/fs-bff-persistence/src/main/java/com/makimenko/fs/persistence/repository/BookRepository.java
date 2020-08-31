package com.makimenko.fs.persistence.repository;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.domain.book.BookGenre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface BookRepository extends MongoRepository<Book, UUID> {

    @Query(value = "{'title': {$regex : ?0, $options: 'i'}}")
    List<Book> findByTitle(String title);

    //TODO: work in progress
    @Query(value = "{'bookGenres.id': {$in : [?0]} }")
    List<Book> findByBookGenre(List<String> bookGenreIds);

}
