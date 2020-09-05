package com.makimenko.fs.web.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataMongoTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public abstract class AbstractTest {

    @Autowired
    protected BookService bookService;

    @Autowired
    protected BookGenreService bookGenreService;

    @Autowired
    protected AuthorService authorService;

}