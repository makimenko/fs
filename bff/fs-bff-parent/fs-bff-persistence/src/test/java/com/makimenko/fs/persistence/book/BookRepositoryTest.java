package com.makimenko.fs.persistence.book;

import com.makimenko.fs.domain.book.Book;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class BookRepositoryTest extends AbstractTest {

    @Test
    public void createAndRead() {
        Book book = new Book();
        book.setId(ObjectId.get());
        book.setTitle("Test Book");
        bookRepository.save(book);

        List<Book> searchResult = bookRepository.findAll();
        assertTrue(searchResult.size() > 0);
    }

    @Test
    public void findByTitle() {
        Book book = new Book();
        book.setId(ObjectId.get());
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
        book.setId(ObjectId.get());
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