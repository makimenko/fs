package com.makimenko.fs.persistence;

import com.makimenko.fs.domain.book.*;
import com.makimenko.fs.persistence.dao.BookDao;
import com.makimenko.fs.persistence.repository.AuthorRepository;
import com.makimenko.fs.persistence.repository.BookGenreRepository;
import com.makimenko.fs.persistence.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@DataMongoTest
public class BookDaoTest {

    public static final String BOOK_GENRE_L1 = UUID.randomUUID().toString();
    public static final String BOOK_GENRE_L2 = UUID.randomUUID().toString();
    public static final UUID AUTHOR_K1 = UUID.randomUUID();
    public static final UUID AUTHOR_K2 = UUID.randomUUID();
    public static final UUID BOOK_B1 = UUID.randomUUID();
    public static final String TITLE_B1 = UUID.randomUUID().toString();
    public static final String NOT_EXISTS = "NOT EXISTS";

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookGenreRepository bookGenreRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookDao dao;


    @BeforeEach
    public void before() {
        BookGenre genreL1 = new BookGenre();
        genreL1.setId(BOOK_GENRE_L1);
        genreL1.setName("Genre L1");
        bookGenreRepository.save(genreL1);

        BookGenre genreL2 = new BookGenre();
        genreL2.setId(BOOK_GENRE_L2);
        genreL2.setName("Genre L2");
        bookGenreRepository.save(genreL2);

        Author authorK1 = new Author();
        authorK1.setId(AUTHOR_K1);
        authorK1.setName("Author K1");
        authorRepository.save(authorK1);

        Author authorK2 = new Author();
        authorK2.setId(AUTHOR_K2);
        authorK2.setName("Author K2");
        authorRepository.save(authorK2);

        Book book = new Book();
        book.setId(BOOK_B1);
        book.setTitle(TITLE_B1);

        book.setAuthors(asList(AUTHOR_K1, AUTHOR_K2));
        book.setBookGenres(asList(BOOK_GENRE_L1, BOOK_GENRE_L2));
        bookRepository.save(book);
    }

    @Test
    public void nullFilter() {
        BookSearchFilter filter = null;
        List<BookList> searchResult = dao.findBooks(filter);
        assertEquals(1, searchResult.size());
    }

    @Test
    public void emptyFilter() {
        BookSearchFilter filter = new BookSearchFilter();
        List<BookList> searchResult = dao.findBooks(filter);
        assertEquals(1, searchResult.size());
    }

    @Test
    public void title() {
        BookSearchFilter filter = new BookSearchFilter();
        filter.setTitle(TITLE_B1);
        List<BookList> searchResult = dao.findBooks(filter);
        assertEquals(1, searchResult.size());
        assertEquals(TITLE_B1, searchResult.get(0).getTitle());
    }

    @Test
    public void bookGernre() {
        BookSearchFilter filter = new BookSearchFilter();
        filter.setBookGenres(asList(BOOK_GENRE_L1));
        List<BookList> searchResult = dao.findBooks(filter);
        assertEquals(1, searchResult.size());
        assertEquals(TITLE_B1, searchResult.get(0).getTitle());
    }

    @Test
    public void authors() {
        BookSearchFilter filter = new BookSearchFilter();
        filter.setAuthors(asList(AUTHOR_K1));
        List<BookList> searchResult = dao.findBooks(filter);
        assertEquals(1, searchResult.size());
        assertEquals(TITLE_B1, searchResult.get(0).getTitle());
    }

    @Test
    public void all() {
        BookSearchFilter filter = new BookSearchFilter();
        filter.setAuthors(asList(AUTHOR_K1));
        filter.setBookGenres(asList(BOOK_GENRE_L1));
        filter.setTitle(TITLE_B1);
        List<BookList> searchResult = dao.findBooks(filter);
        assertEquals(1, searchResult.size());
        assertEquals(TITLE_B1, searchResult.get(0).getTitle());
    }

    @Test
    public void titleNotExists() {
        BookSearchFilter filter = new BookSearchFilter();
        filter.setAuthors(asList(AUTHOR_K1));
        filter.setBookGenres(asList(BOOK_GENRE_L1));
        filter.setTitle(NOT_EXISTS);
        List<BookList> searchResult = dao.findBooks(filter);
        assertEquals(0, searchResult.size());
    }

    @Test
    public void bookGenreNotExists() {
        BookSearchFilter filter = new BookSearchFilter();
        filter.setAuthors(asList(AUTHOR_K1));
        filter.setBookGenres(asList(NOT_EXISTS, NOT_EXISTS));
        filter.setTitle(TITLE_B1);
        List<BookList> searchResult = dao.findBooks(filter);
        assertEquals(0, searchResult.size());
    }

    @Test
    public void authorNotExists() {
        BookSearchFilter filter = new BookSearchFilter();
        filter.setAuthors(asList(UUID.randomUUID()));
        filter.setBookGenres(asList(BOOK_GENRE_L1));
        filter.setTitle(TITLE_B1);
        List<BookList> searchResult = dao.findBooks(filter);
        assertEquals(0, searchResult.size());
    }

}