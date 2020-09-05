package com.makimenko.fs.web.controller;

import com.makimenko.fs.domain.book.BookGenre;
import com.makimenko.fs.web.service.book.BookGenreService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Books", description = "Book genres operations")
@RestController
@CrossOrigin()
@RequestMapping(BookGenreController.REST_PATH)
public class BookGenreController {

    protected static final String REST_PATH = "/api/v1/bookGenre";

    private BookGenreService bookGenreService;

    public BookGenreController(BookGenreService bookGenreService) {
        this.bookGenreService = bookGenreService;
    }

    @GetMapping
    public List<BookGenre> get(@RequestBody(required = false) BookGenre template) {
        return bookGenreService.find(template);
    }

    @GetMapping("{id}")
    public BookGenre get(@PathVariable String id) {
        return bookGenreService.get(id);
    }

    @PostMapping
    public BookGenre post(@Valid @RequestBody BookGenre book) {
        return bookGenreService.save(book);
    }

}
