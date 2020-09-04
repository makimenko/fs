package com.makimenko.fs.persistence.book;

import com.makimenko.fs.persistence.repository.AuthorRepository;
import com.makimenko.fs.persistence.repository.BookGenreRepository;
import com.makimenko.fs.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataMongoTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public abstract class AbstractTest {

    @Autowired
    protected BookRepository bookRepository;

    @Autowired
    protected BookGenreRepository bookGenreRepository;

    @Autowired
    protected AuthorRepository authorRepository;

}