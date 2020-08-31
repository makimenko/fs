package com.makimenko.fs.persistence;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.domain.book.BookGenre;
import com.makimenko.fs.persistence.repository.BookGenreRepository;
import com.makimenko.fs.persistence.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ActiveProfiles("test")
@DataMongoTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookGenreRepository bookGenreRepository;

    @Test
    public void createAndRead() {
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle("Test Book");
        bookRepository.save(book);

        List<Book> searchResult = bookRepository.findAll();
        assertTrue(searchResult.size() > 0);
    }


    @Test
    public void findByTitle() {
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle("ABC");
        bookRepository.save(book);

        List<Book> searchResult;
        searchResult = bookRepository.findByTitle("AAA");
        assertEquals(0, searchResult.size());

        searchResult = bookRepository.findByTitle("abc");
        assertEquals(1, searchResult.size());
    }

    @Test
    public void findByBookGenre() {

        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle("The Catcher In The Rye");

        book.setBookGenreIds(Arrays.asList("C", "D"));
        bookRepository.save(book);

        List<Book> searchResult;

        searchResult = bookRepository.findByBookGenre(Arrays.asList("M"));
        assertEquals(0, searchResult.size());

        searchResult = bookRepository.findByBookGenre(Arrays.asList("C"));
        assertEquals(1, searchResult.size());

        searchResult = bookRepository.findByBookGenre(Arrays.asList("M", "D"));
        assertEquals(1, searchResult.size());

        searchResult = bookRepository.findByBookGenre(Arrays.asList());
        assertEquals(0, searchResult.size());
    }


    @Test
    public void queryJoin() {
        BookGenre comedy = new BookGenre();
        comedy.setId("X");
        comedy.setName("XYZ");

        bookGenreRepository.save(comedy);

        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle("Test Book");


        book.setBookGenreIds(Arrays.asList("X"));

        bookRepository.save(book);

        // TODO: implement join
        // https://docs.mongodb.com/manual/reference/operator/aggregation/lookup/#examples
        // https://habr.com/ru/post/413123/

    }

}