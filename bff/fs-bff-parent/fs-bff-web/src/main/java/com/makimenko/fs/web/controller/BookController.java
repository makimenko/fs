package com.makimenko.fs.web.controller;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.domain.book.BookList;
import com.makimenko.fs.web.service.book.BookService;
import io.swagger.annotations.Api;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Books", description = "Book library operations")
@RestController
@CrossOrigin()
@RequestMapping(BookController.REST_PATH)
public class BookController {

    protected static final String REST_PATH = "/api/v1/book";

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(path = "/find")
    public List<BookList> find(@RequestBody(required = false) Book templateBook) {
        return bookService.find(templateBook);
    }

    @GetMapping("{id}")
    public Book get(@PathVariable ObjectId id) {
        return bookService.get(id);
    }

    @PostMapping
    public Book post(@Valid @RequestBody Book book) {
        return bookService.save(book);
    }

}
