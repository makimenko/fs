package com.makimenko.fs.web.controller;

import com.makimenko.fs.common.dao.BookDao;
import com.makimenko.fs.common.domain.book.Book;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Books", description = "Book library operations")
@RestController
@CrossOrigin()
@RequestMapping(LibraryController.REST_PATH)
public class LibraryController {

    protected static final String REST_PATH = "/api/v1";

    private BookDao bookDao;

    public LibraryController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book bookEntity) {
        return bookDao.createBook(bookEntity);
    }

}
