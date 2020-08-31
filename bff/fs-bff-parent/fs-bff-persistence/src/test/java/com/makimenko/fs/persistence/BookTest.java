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
        assertEquals(1, books.size());
    }

}

