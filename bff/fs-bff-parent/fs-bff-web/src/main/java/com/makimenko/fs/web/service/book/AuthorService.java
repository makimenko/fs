package com.makimenko.fs.web.service.book;

import com.makimenko.fs.domain.book.Author;

import java.util.UUID;

public interface AuthorService {

    Author getAuthor(UUID id);

    Author saveAuthor(Author author);

}
