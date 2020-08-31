package com.makimenko.fs.persistence.dao;

import com.makimenko.fs.common.dao.BookDao;
import com.makimenko.fs.common.domain.book.Book;
import com.makimenko.fs.persistence.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDaoMongoImpl implements BookDao {

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

}
