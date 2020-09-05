package com.makimenko.fs.web.service.book;

import com.makimenko.fs.domain.book.Author;
import org.bson.types.ObjectId;

public interface AuthorService {

    Author getAuthor(ObjectId id);

    Author saveAuthor(Author author);

}
