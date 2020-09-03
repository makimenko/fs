package com.makimenko.fs.persistence;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.persistence.repository.AuthorRepository;
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
import static org.junit.Assert.assertTrue;

@ActiveProfiles("test")
@DataMongoTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookGenreRepository bookGenreRepository;

    @Autowired
    private AuthorRepository authorRepository;

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

        book.setBookGenres(asList("C", "D"));
        bookRepository.save(book);

        List<Book> searchResult;

        searchResult = bookRepository.findByBookGenre(asList("M"));
        assertEquals(0, searchResult.size());

        searchResult = bookRepository.findByBookGenre(asList("C"));
        assertEquals(1, searchResult.size());

        searchResult = bookRepository.findByBookGenre(asList("M", "D"));
        assertEquals(1, searchResult.size());

        searchResult = bookRepository.findByBookGenre(asList());
        assertEquals(0, searchResult.size());
    }



}