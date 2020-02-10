package com.makimenko.fs.bff.dao;

import com.makimenko.fs.bff.domain.book.Book;

import java.util.List;

public interface BookDao {

    List<Book> getAllBooks();

    Book createBook(Book book);

}
