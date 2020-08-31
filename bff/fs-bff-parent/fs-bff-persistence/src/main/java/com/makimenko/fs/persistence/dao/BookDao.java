package com.makimenko.fs.persistence.dao;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.domain.book.BookGenre;

import java.util.List;

public interface BookDao {

    List<Book> getAllBooks();

    Book createBook(Book book);

    List<Book> findByTitle(String title);

    List<Book> findByBookGenre(BookGenre bookGenre);

}
