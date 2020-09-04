package com.makimenko.fs.web.controller;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.persistence.repository.BookRepository;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Api(tags = "Books", description = "Book library operations")
@RestController
@CrossOrigin()
@RequestMapping(LibraryController.REST_PATH)
public class LibraryController {

    protected static final String REST_PATH = "/api/v1";

    private BookRepository bookRepository;

    public LibraryController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBook(@PathVariable UUID id) {
        return bookRepository.findById(id);
    }

    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book bookEntity) {
        return bookRepository.save(bookEntity);
    }

}
