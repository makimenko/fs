package com.makimenko.fs.persistence.mongodb.dao;

import com.makimenko.fs.common.dao.BookDao;
import com.makimenko.fs.common.domain.book.Book;
import com.makimenko.fs.persistence.mongodb.entity.BookEntity;
import com.makimenko.fs.persistence.mongodb.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookDaoMongoImpl implements BookDao {

    private BookRepository bookRepository;

    public BookDaoMongoImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(entity -> entity.toDomain())
                .collect(Collectors.toList());
    }

    @Override
    public Book createBook(Book book) {
        BookEntity bookEntity = new BookEntity(book);
        bookEntity = bookRepository.save(bookEntity);
        return bookEntity.toDomain();
    }

}
