package com.makimenko.fs.web.controller;

import com.makimenko.fs.common.dao.BookDao;
import com.makimenko.fs.common.domain.book.Book;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/v1")
public class LibraryController {

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
