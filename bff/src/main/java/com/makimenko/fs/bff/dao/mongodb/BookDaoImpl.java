package com.makimenko.fs.bff.dao.mongodb;


import com.makimenko.fs.bff.dao.BookDao;
import com.makimenko.fs.bff.dao.mongodb.entity.BookEntity;
import com.makimenko.fs.bff.domain.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bookRepository;

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
