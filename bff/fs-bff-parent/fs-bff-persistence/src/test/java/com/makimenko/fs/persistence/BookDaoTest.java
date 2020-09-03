package com.makimenko.fs.persistence;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.domain.book.BookGenre;
import com.makimenko.fs.domain.book.BookList;
import com.makimenko.fs.persistence.dao.BookDao;
import com.makimenko.fs.persistence.repository.BookGenreRepository;
import com.makimenko.fs.persistence.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ActiveProfiles("test")
@DataMongoTest
public class BookDaoTest {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private BookGenreRepository bookGenreRepo;

    @Autowired
    private BookDao dao;

    @Test
    public void cachedRefData() {
        // Create book genre
        BookGenre comedy = new BookGenre();
        comedy.setId("X");
        comedy.setName("XYZ");
        bookGenreRepo.save(comedy);

        // Create book
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle("Test Book");
        book.setBookGenres(asList("X"));
        bookRepo.save(book);

        // Validate:
        List<BookList> bookList;
        bookList = dao.findBooks(asList("Y"));
        assertEquals(0, bookList.size());

        bookList = dao.findBooks(asList("X"));
        assertEquals(1, bookList.size());

        BookList i = bookList.get(0);
        assertEquals("Test Book", i.getTitle());
        assertNotNull(i.getBookGenres());
        assertEquals("XYZ", i.getBookGenres().get(0).getName());


        comedy.setName("XYZ-UPDATED");
        bookGenreRepo.save(comedy);
        bookList = dao.findBooks(asList("X"));
        i = bookList.get(0);
        // TODO: test failing (value not cached)
        assertEquals("XYZ", i.getBookGenres().get(0).getName());
    }

}