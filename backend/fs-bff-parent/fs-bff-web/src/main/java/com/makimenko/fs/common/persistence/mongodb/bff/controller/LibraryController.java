package com.makimenko.fs.common.persistence.mongodb.bff.controller;

import dao.BookDao;
import com.makimenko.fs.bff.domain.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/v1")
public class LibraryController {


    @Autowired
    BookDao bookDao;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book bookEntity) {
        return bookDao.createBook(bookEntity);
    }

}
