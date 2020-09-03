package com.makimenko.fs.persistence.dao;

import com.makimenko.fs.domain.book.BookList;

import java.util.List;

public interface BookDao {

    List<BookList> findBooks(List<String> bookGenreIds);

}
