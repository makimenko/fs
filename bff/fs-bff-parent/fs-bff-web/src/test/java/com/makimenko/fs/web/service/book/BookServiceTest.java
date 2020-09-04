package com.makimenko.fs.web.service.book;

import com.makimenko.fs.domain.book.Author;
import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.domain.book.BookGenre;
import com.makimenko.fs.domain.book.BookList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class BookServiceTest extends AbstractTest {

    public static final String BOOK_GENRE_L1 = "L1";
    public static final String BOOK_GENRE_L2 = "L2";
    public static final UUID AUTHOR_K1 = UUID.randomUUID();
    public static final UUID AUTHOR_K2 = UUID.randomUUID();
    public static final UUID BOOK_B1 = UUID.randomUUID();
    public static final String TITLE_B1 = "Dream Book";
    public static final String NOT_EXISTS = "NOT EXISTS";

    @BeforeEach
    public void before() {
        BookGenre genreL1 = new BookGenre();
        genreL1.setId(BOOK_GENRE_L1);
        genreL1.setName("Genre L1");
        bookService.saveBookGenre(genreL1);

        BookGenre genreL2 = new BookGenre();
        genreL2.setId(BOOK_GENRE_L2);
        genreL2.setName("Genre L2");
        bookService.saveBookGenre(genreL2);

        Author authorK1 = new Author();
        authorK1.setId(AUTHOR_K1);
        authorK1.setName("Author K1");
        authorService.saveAuthor(authorK1);

        Author authorK2 = new Author();
        authorK2.setId(AUTHOR_K2);
        authorK2.setName("Author K2");
        authorService.saveAuthor(authorK2);

        Book book = new Book();
        book.setId(BOOK_B1);
        book.setTitle(TITLE_B1);

        book.setAuthors(asList(AUTHOR_K1, AUTHOR_K2));
        book.setBookGenres(asList(BOOK_GENRE_L1, BOOK_GENRE_L2));
        bookService.saveBook(book);
    }

    @Test
    public void nullFilter() {
        BookSearchFilter filter = null;
        List<BookList> searchResult = bookService.findBooks(filter);
        assertEquals(1, searchResult.size());
    }

    @Test
    public void emptyFilter() {
        BookSearchFilter filter = new BookSearchFilter();
        List<BookList> searchResult = bookService.findBooks(filter);
        assertEquals(1, searchResult.size());
    }

    @Test
    public void title() {
        BookSearchFilter filter = new BookSearchFilter();
        filter.setTitle(TITLE_B1);
        List<BookList> searchResult = bookService.findBooks(filter);
        assertEquals(1, searchResult.size());
        assertEquals(TITLE_B1, searchResult.get(0).getTitle());
    }

    @Test
    public void titlePartial() {
        BookSearchFilter filter = new BookSearchFilter();
        filter.setTitle(TITLE_B1.substring(0, 9));
        List<BookList> searchResult = bookService.findBooks(filter);
        assertEquals(1, searchResult.size());
        assertEquals(TITLE_B1, searchResult.get(0).getTitle());
    }

    @Test
    public void bookGernre() {
        BookSearchFilter filter = new BookSearchFilter();
        filter.setBookGenres(asList(BOOK_GENRE_L1));
        List<BookList> searchResult = bookService.findBooks(filter);
        assertEquals(1, searchResult.size());
        assertEquals(TITLE_B1, searchResult.get(0).getTitle());
    }

    @Test
    public void authors() {
        BookSearchFilter filter = new BookSearchFilter();
        filter.setAuthors(asList(AUTHOR_K1));
        List<BookList> searchResult = bookService.findBooks(filter);
        assertEquals(1, searchResult.size());
        assertEquals(TITLE_B1, searchResult.get(0).getTitle());
    }

    @Test
    public void all() {
        BookSearchFilter filter = new BookSearchFilter();
        filter.setAuthors(asList(AUTHOR_K1));
        filter.setBookGenres(asList(BOOK_GENRE_L1));
        filter.setTitle(TITLE_B1);
        List<BookList> searchResult = bookService.findBooks(filter);
        assertEquals(1, searchResult.size());
        assertEquals(TITLE_B1, searchResult.get(0).getTitle());
    }

    @Test
    public void titleNotExists() {
        BookSearchFilter filter = new BookSearchFilter();
        filter.setAuthors(asList(AUTHOR_K1));
        filter.setBookGenres(asList(BOOK_GENRE_L1));
        filter.setTitle(NOT_EXISTS);
        List<BookList> searchResult = bookService.findBooks(filter);
        assertEquals(0, searchResult.size());
    }

    @Test
    public void bookGenreNotExists() {
        BookSearchFilter filter = new BookSearchFilter();
        filter.setAuthors(asList(AUTHOR_K1));
        filter.setBookGenres(asList(NOT_EXISTS, NOT_EXISTS));
        filter.setTitle(TITLE_B1);
        List<BookList> searchResult = bookService.findBooks(filter);
        assertEquals(0, searchResult.size());
    }

    @Test
    public void authorNotExists() {
        BookSearchFilter filter = new BookSearchFilter();
        filter.setAuthors(asList(UUID.randomUUID()));
        filter.setBookGenres(asList(BOOK_GENRE_L1));
        filter.setTitle(TITLE_B1);
        List<BookList> searchResult = bookService.findBooks(filter);
        assertEquals(0, searchResult.size());
    }

}