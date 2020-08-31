package com.makimenko.fs.persistence;

import com.makimenko.fs.domain.book.Book;
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

        List<Book> books = dao.getAllBooks();
        assertTrue(books.size() > 0);
    }


    @Test
    public void findByTitle() {
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle("ABC");
        dao.createBook(book);

        List<Book> books;
        books = dao.findByTitle("AAA");
        assertEquals(0, books.size());

        books = dao.findByTitle("abc");
        assertEquals(1, books.size());
    }
}

