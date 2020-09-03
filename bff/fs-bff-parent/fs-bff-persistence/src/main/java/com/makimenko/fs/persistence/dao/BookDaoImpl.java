package com.makimenko.fs.persistence.dao;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.domain.book.BookList;
import com.makimenko.fs.domain.book.BookSearchFilter;
import com.makimenko.fs.persistence.repository.BookGenreRepository;
import com.makimenko.fs.persistence.repository.BookRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.makimenko.fs.persistence.dao.DaoUtils.refList;

@Component
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private BookGenreRepository bookGenreRepository;

    public BookDaoImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<BookList> findBooks(List<String> bookGenres) {
        List<BookList> result = bookRepo.findBookList(bookGenres)
                .stream()
                .map(this::toBookList)
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public List<BookList> findBooks(BookSearchFilter filter) {
        Query query = new Query();
        query.addCriteria(getCriteria(filter))
                .fields()
                .include("id")
                .include("title")
                .include("bookGenres");

        List<Book> list = mongoTemplate.find(query, Book.class);
        List<BookList> convertedList = list.stream()
                .map(this::toBookList)
                .collect(Collectors.toList());

        return convertedList;
    }

    private Criteria getCriteria(BookSearchFilter filter) {
        Criteria criteria = new Criteria();
        if (filter != null) {
            if (!CollectionUtils.isEmpty(filter.getBookGenres())) {
                criteria.and("bookGenres").in(filter.getBookGenres());
            }
            if (!CollectionUtils.isEmpty(filter.getAuthors())) {
                criteria.and("authors").in(filter.getAuthors());
            }
            if (!Strings.isBlank(filter.getTitle())) {
                criteria.and("title").in(filter.getTitle());
            }
        }
        return criteria;
    }

    private BookList toBookList(Book book) {
        BookList result = new BookList();
        result.setId(book.getId());
        result.setTitle(book.getTitle());
        result.setBookGenres(refList(book.getBookGenres(), bookGenreRepository::findById));
        return result;
    }


}
