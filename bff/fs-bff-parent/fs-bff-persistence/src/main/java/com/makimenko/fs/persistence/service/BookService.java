package com.makimenko.fs.persistence.service;

import com.makimenko.fs.domain.book.BookList;

import java.util.List;

public interface BookService {

    List<BookList> findBooks(List<String> bookGenres);

    List<BookList> findBooks(BookSearchFilter filter);

}
