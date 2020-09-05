package com.makimenko.fs.persistence.repository;

import com.makimenko.fs.domain.book.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, ObjectId> {

    @Query(value = "{'title': {$regex : ?0, $options: 'i'}}")
    List<Book> findByTitle(String title);

    @Query(value = "{'bookGenres': {$in : [?0]} }")
    List<Book> findByBookGenre(List<String> bookGenres);

    @Query(
            value = "{'bookGenres': {$in : [?0]} }",
            fields = "{id:1, title:1, bookGenres:1}"
    )
    List<Book> findBookList(List<String> bookGenreIds);

}
