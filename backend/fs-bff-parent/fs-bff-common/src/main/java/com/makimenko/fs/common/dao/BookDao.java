package com.makimenko.fs.common.dao;


import com.makimenko.fs.common.domain.book.Book;

import java.util.List;

public interface BookDao {

    List<Book> getAllBooks();

    Book createBook(Book book);

}
