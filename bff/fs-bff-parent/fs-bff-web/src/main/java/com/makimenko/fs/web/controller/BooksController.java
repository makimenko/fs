package com.makimenko.fs.web.controller;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.domain.book.BookList;
import com.makimenko.fs.web.service.book.BookSearchFilter;
import com.makimenko.fs.web.service.book.BookService;
import io.swagger.annotations.Api;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Books", description = "Book library operations")
@RestController
@CrossOrigin()
@RequestMapping(BooksController.REST_PATH)
public class BooksController {

    protected static final String REST_PATH = "/api/v1/books";

    private BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookList> findBooks(@RequestBody(required = false) BookSearchFilter filter) {
        return bookService.findBooks(filter);
    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable ObjectId id) {
        return bookService.getBook(id);
    }

    @PostMapping
    public Book createBook(@Valid @RequestBody Book book) {
        return bookService.saveBook(book);
    }

}
