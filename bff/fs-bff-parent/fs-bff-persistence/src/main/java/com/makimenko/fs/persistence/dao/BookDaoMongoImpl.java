package com.makimenko.fs.persistence.dao;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDaoMongoImpl implements BookDao {

    @Autowired
    public MongoTemplate mongoTemplate;

    private BookRepository bookRepository;

    public BookDaoMongoImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

}
