package com.makimenko.fs.persistence.mongodb;


import com.makimenko.fs.common.dao.BookDao;
import com.makimenko.fs.common.domain.book.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookIT {

    @Autowired
    private BookDao dao;

    @Test
    public void getAllBooks() {
        List<Book> books = dao.getAllBooks();
    }

}

