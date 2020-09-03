package com.makimenko.fs.persistence.repository;

import com.makimenko.fs.domain.book.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface BookRepository extends MongoRepository<Book, UUID> {

    @Query(value = "{'title': {$regex : ?0, $options: 'i'}}")
    List<Book> findByTitle(String title);

    @Query(value = "{'bookGenreIds': {$in : [?0]} }")
    List<Book> findByBookGenre(List<String> bookGenreIds);

    @Query(
            value = "{'bookGenreIds': {$in : [?0]} }",
            fields = "{id:1, title:1, bookGenreIds:1}"
    )
    List<Book> findBookList(List<String> bookGenreIds);

}
