package com.makimenko.fs.persistence;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.domain.book.BookGenre;
import com.makimenko.fs.persistence.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ActiveProfiles("test")
@DataMongoTest
public class BookTest {

    @Autowired
    private BookDao dao;

    @Test
    public void createAndRead() {
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle("Test Book");
        dao.createBook(book);

        List<Book> searchResult = dao.getAllBooks();
        assertTrue(searchResult.size() > 0);
    }


    @Test
    public void findByTitle() {
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle("ABC");
        dao.createBook(book);

        List<Book> searchResult;
        searchResult = dao.findByTitle("AAA");
        assertEquals(0, searchResult.size());

        searchResult = dao.findByTitle("abc");
        assertEquals(1, searchResult.size());
    }

    @Test
    public void findByBookGenre() {
        BookGenre comedy = new BookGenre();
        comedy.setId("C");
        comedy.setName("Comedy");

        BookGenre drama = new BookGenre();
        drama.setId("D");
        drama.setName("Drama");

        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle("The Catcher In The Rye");

        book.setBookGenres(new BookGenre[]{comedy});
        dao.createBook(book);

        List<Book> searchResult;
        searchResult = dao.findByBookGenre(drama);
        assertEquals(0, searchResult.size());

        searchResult = dao.findByBookGenre(comedy);
        assertEquals(0, searchResult.size());

    }

}

