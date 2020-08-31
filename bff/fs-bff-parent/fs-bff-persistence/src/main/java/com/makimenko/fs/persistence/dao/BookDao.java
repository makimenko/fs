package com.makimenko.fs.persistence.dao;


import com.makimenko.fs.domain.book.Book;

import java.util.List;

public interface BookDao {

    List<Book> getAllBooks();

    Book createBook(Book book);

}
