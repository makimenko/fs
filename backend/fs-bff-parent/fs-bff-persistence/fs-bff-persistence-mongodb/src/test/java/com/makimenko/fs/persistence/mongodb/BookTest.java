package com.makimenko.fs.persistence.mongodb;


import com.makimenko.fs.common.dao.BookDao;
import com.makimenko.fs.common.domain.book.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BookTest extends AbstractTest {

    @Autowired
    BookDao dao;

    @Test
    public void dummy() {
        List<Book> books = dao.getAllBooks();
    }


}

