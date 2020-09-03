package com.makimenko.fs.persistence.dao;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.domain.book.BookList;
import com.makimenko.fs.persistence.repository.BookGenreRepository;
import com.makimenko.fs.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.makimenko.fs.persistence.dao.DaoUtils.refList;

@Component
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private BookGenreRepository bookGenreRepository;

    public BookDaoImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<BookList> findBooks(List<String> bookGenres) {
        List<BookList> result = bookRepo.findBookList(bookGenres)
                .stream()
                .map(this::toBookList)
                .collect(Collectors.toList());

        return result;
    }

    private BookList toBookList(Book book) {
        BookList result = new BookList();
        result.setId(book.getId());
        result.setTitle(book.getTitle());
        result.setBookGenres(refList(book.getBookGenres(), bookGenreRepository::findById));
        return result;
    }


}
