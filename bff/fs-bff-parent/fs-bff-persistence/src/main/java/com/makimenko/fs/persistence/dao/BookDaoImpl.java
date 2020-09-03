package com.makimenko.fs.persistence.dao;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.domain.book.BookGenre;
import com.makimenko.fs.domain.book.BookList;
import com.makimenko.fs.persistence.cache.BookGenreCache;
import com.makimenko.fs.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private BookGenreCache bookGenreCache;

    public BookDaoImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<BookList> findBooks(List<String> bookGenreIds) {
        List<BookList> result = bookRepo.findBookList(bookGenreIds)
                .stream()
                .map(this::toBookList)
                .collect(Collectors.toList());

        return result;
    }

    private BookList toBookList(Book book) {
        BookList result = new BookList();
        result.setId(book.getId());
        result.setTitle(book.getTitle());
        result.setBookGenres(bookGenreCache.findAll(book.getBookGenreIds()));
        return result;
    }



}
