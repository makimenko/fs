package com.makimenko.fs.persistence.cache;

import com.makimenko.fs.domain.book.BookGenre;
import org.springframework.stereotype.Component;

@Component
public interface BookGenreCache extends Cache<BookGenre> {

}
