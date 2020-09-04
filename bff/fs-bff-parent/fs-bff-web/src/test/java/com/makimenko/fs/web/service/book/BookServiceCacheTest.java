package com.makimenko.fs.web.service.book;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.domain.book.BookGenre;
import com.makimenko.fs.domain.book.BookList;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BookServiceCacheTest extends AbstractTest {

    @Test
    public void cachedRefData() {
        // Create book genre
        BookGenre comedy = new BookGenre();
        comedy.setId("X");
        comedy.setName("XYZ");
        bookService.saveBookGenre(comedy);

        // Create book
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle("Test Book");
        book.setBookGenres(asList("X"));
        bookService.saveBook(book);

        // Validate:
        List<BookList> bookList;
        bookList = bookService.findBooks(asList("Y"));
        assertEquals(0, bookList.size());

        bookList = bookService.findBooks(asList("X"));
        assertEquals(1, bookList.size());

        BookList i = bookList.get(0);
        assertEquals("Test Book", i.getTitle());
        assertNotNull(i.getBookGenres());
        assertEquals("XYZ", i.getBookGenres().get(0).getName());

        comedy.setName("XYZ-UPDATED");
        bookService.saveBookGenre(comedy);
        bookList = bookService.findBooks(asList("X"));
        i = bookList.get(0);
        // TODO: test failing (value not cached)
        assertEquals("XYZ", i.getBookGenres().get(0).getName());
    }

}