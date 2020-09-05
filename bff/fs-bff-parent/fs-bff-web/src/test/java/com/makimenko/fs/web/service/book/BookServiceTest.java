package com.makimenko.fs.web.service.book;

import com.makimenko.fs.domain.book.Author;
import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.domain.book.BookGenre;
import com.makimenko.fs.domain.book.BookList;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class BookServiceTest extends AbstractTest {

    public static final String BOOK_GENRE_L1 = "L1";
    public static final String BOOK_GENRE_L2 = "L2";
    public static final ObjectId AUTHOR_K1 = ObjectId.get();
    public static final ObjectId AUTHOR_K2 = ObjectId.get();
    public static final ObjectId BOOK_B1 = ObjectId.get();
    public static final String TITLE_B1 = "Dream Book";
    public static final String NOT_EXISTS = "NOT EXISTS";

    @BeforeEach
    public void before() {
        BookGenre genreL1 = new BookGenre();
        genreL1.setId(BOOK_GENRE_L1);
        genreL1.setName("Genre L1");
        bookGenreService.save(genreL1);

        BookGenre genreL2 = new BookGenre();
        genreL2.setId(BOOK_GENRE_L2);
        genreL2.setName("Genre L2");
        bookGenreService.save(genreL2);

        Author authorK1 = new Author();
        authorK1.setId(AUTHOR_K1);
        authorK1.setName("Author K1");
        authorService.save(authorK1);

        Author authorK2 = new Author();
        authorK2.setId(AUTHOR_K2);
        authorK2.setName("Author K2");
        authorService.save(authorK2);

        Book book = new Book();
        book.setId(BOOK_B1);
        book.setTitle(TITLE_B1);

        book.setAuthors(asList(AUTHOR_K1, AUTHOR_K2));
        book.setBookGenres(asList(BOOK_GENRE_L1, BOOK_GENRE_L2));
        bookService.save(book);
    }

    @Test
    public void nullFilter() {
        Book filter = null;
        List<BookList> searchResult = bookService.find(filter);
        assertEquals(1, searchResult.size());
    }

    @Test
    public void emptyFilter() {
        Book filter = new Book();
        List<BookList> searchResult = bookService.find(filter);
        assertEquals(1, searchResult.size());
    }

    @Test
    public void title() {
        Book filter = new Book();
        filter.setTitle(TITLE_B1);
        List<BookList> searchResult = bookService.find(filter);
        assertEquals(1, searchResult.size());
        assertEquals(TITLE_B1, searchResult.get(0).getTitle());
    }

    @Test
    public void titlePartial() {
        Book filter = new Book();
        filter.setTitle(TITLE_B1.substring(0, 9));
        List<BookList> searchResult = bookService.find(filter);
        assertEquals(1, searchResult.size());
        assertEquals(TITLE_B1, searchResult.get(0).getTitle());
    }

    @Test
    public void bookGernre() {
        Book filter = new Book();
        filter.setBookGenres(asList(BOOK_GENRE_L1));
        List<BookList> searchResult = bookService.find(filter);
        assertEquals(1, searchResult.size());
        assertEquals(TITLE_B1, searchResult.get(0).getTitle());
    }

    @Test
    public void authors() {
        Book filter = new Book();
        filter.setAuthors(asList(AUTHOR_K1));
        List<BookList> searchResult = bookService.find(filter);
        assertEquals(1, searchResult.size());
        assertEquals(TITLE_B1, searchResult.get(0).getTitle());
    }

    @Test
    public void all() {
        Book filter = new Book();
        filter.setAuthors(asList(AUTHOR_K1));
        filter.setBookGenres(asList(BOOK_GENRE_L1));
        filter.setTitle(TITLE_B1);
        List<BookList> searchResult = bookService.find(filter);
        assertEquals(1, searchResult.size());
        assertEquals(TITLE_B1, searchResult.get(0).getTitle());
    }

    @Test
    public void titleNotExists() {
        Book filter = new Book();
        filter.setAuthors(asList(AUTHOR_K1));
        filter.setBookGenres(asList(BOOK_GENRE_L1));
        filter.setTitle(NOT_EXISTS);
        List<BookList> searchResult = bookService.find(filter);
        assertEquals(0, searchResult.size());
    }

    @Test
    public void bookGenreNotExists() {
        Book filter = new Book();
        filter.setAuthors(asList(AUTHOR_K1));
        filter.setBookGenres(asList(NOT_EXISTS, NOT_EXISTS));
        filter.setTitle(TITLE_B1);
        List<BookList> searchResult = bookService.find(filter);
        assertEquals(0, searchResult.size());
    }

    @Test
    public void authorNotExists() {
        Book filter = new Book();
        filter.setAuthors(asList(ObjectId.get()));
        filter.setBookGenres(asList(BOOK_GENRE_L1));
        filter.setTitle(TITLE_B1);
        List<BookList> searchResult = bookService.find(filter);
        assertEquals(0, searchResult.size());
    }

}