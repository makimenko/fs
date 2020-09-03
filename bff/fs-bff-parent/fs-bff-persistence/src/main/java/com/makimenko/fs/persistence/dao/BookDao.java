package com.makimenko.fs.persistence.dao;

import com.makimenko.fs.domain.book.BookList;
import com.makimenko.fs.domain.book.BookSearchFilter;

import java.util.List;

public interface BookDao {

    List<BookList> findBooks(List<String> bookGenres);

    List<BookList> findBooks(BookSearchFilter filter);

}
