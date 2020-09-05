package com.makimenko.fs.web.service.book;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.domain.book.BookGenre;
import com.makimenko.fs.domain.book.BookList;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        bookGenreService.save(comedy);

        // Create book
        Book book = new Book();
        book.setId(ObjectId.get());
        book.setTitle("Test Book");
        book.setBookGenres(asList("X"));
        bookService.save(book);

        // Validate:
        List<BookList> bookList;
        bookList = bookService.find(bookGenres("Y"));
        assertEquals(0, bookList.size());

        bookList = bookService.find(bookGenres("X"));
        assertEquals(1, bookList.size());

        BookList i = bookList.get(0);
        assertEquals("Test Book", i.getTitle());
        assertNotNull(i.getBookGenres());
        assertEquals("XYZ", i.getBookGenres().get(0).getName());

        comedy.setName("XYZ-UPDATED");
        bookGenreService.save(comedy);
        bookList = bookService.find(bookGenres("X"));
        i = bookList.get(0);
        // TODO: test failing (value not cached)
        assertEquals("XYZ", i.getBookGenres().get(0).getName());
    }

    private Book bookGenres(String... bookGenres) {
        Book template = new Book();
        template.setBookGenres(asList(bookGenres));
        return template;
    }


}