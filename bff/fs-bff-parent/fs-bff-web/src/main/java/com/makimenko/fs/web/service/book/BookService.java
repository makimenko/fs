package com.makimenko.fs.web.service.book;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.domain.book.BookGenre;
import com.makimenko.fs.domain.book.BookList;

import java.util.List;
import java.util.UUID;

public interface BookService {

    List<BookList> findBooks(List<String> bookGenres);

    List<BookList> findBooks(BookSearchFilter filter);

    Book getBook(UUID id);

    Book saveBook(Book book);

    BookGenre getBookGenre(String id);
    BookGenre saveBookGenre(BookGenre bookGenre);

}
