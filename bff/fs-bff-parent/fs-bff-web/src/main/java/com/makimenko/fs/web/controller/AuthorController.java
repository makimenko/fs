package com.makimenko.fs.web.controller;

import com.makimenko.fs.domain.book.Author;
import com.makimenko.fs.domain.book.AuthorList;
import com.makimenko.fs.web.service.book.AuthorService;
import io.swagger.annotations.Api;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Authors", description = "Authors operations")
@RestController
@RequestMapping(AuthorController.REST_PATH)
public class AuthorController {

    protected static final String REST_PATH = "/api/v1/author";

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorList> get() {
        return authorService.find(null);
    }

    @GetMapping("{id}")
    public Author get(@PathVariable ObjectId id) {
        return authorService.get(id);
    }

    @PostMapping
    public Author post(@Valid @RequestBody Author author) {
        return authorService.save(author);
    }

}
