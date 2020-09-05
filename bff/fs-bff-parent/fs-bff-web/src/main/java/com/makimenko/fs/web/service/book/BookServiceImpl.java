package com.makimenko.fs.web.service.book;

import com.makimenko.fs.domain.book.Book;
import com.makimenko.fs.domain.book.BookGenre;
import com.makimenko.fs.domain.book.BookList;
import com.makimenko.fs.persistence.repository.BookGenreRepository;
import com.makimenko.fs.persistence.repository.BookRepository;
import com.makimenko.fs.web.service.ServiceException;
import org.apache.logging.log4j.util.Strings;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.makimenko.fs.web.service.ServiceUtils.refList;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private BookGenreRepository bookGenreRepository;


    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookList> findBooks(List<String> bookGenres) {
        List<BookList> result = bookRepository.findBookList(bookGenres)
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

    @Override
    public Book getBook(ObjectId id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Book not found: " + id));
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public BookGenre getBookGenre(String id) {
        return bookGenreRepository.findById(id)
                .orElseThrow(() -> new ServiceException("BookGenre not found: " + id));
    }

    @Override
    public BookGenre saveBookGenre(BookGenre bookGenre) {
        return bookGenreRepository.save(bookGenre);
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
                criteria.and("title").regex(filter.getTitle(), "i");
            }
        }
        return criteria;
    }

    private BookList toBookList(Book book) {
        BookList result = new BookList();
        result.setId(book.getId());
        result.setTitle(book.getTitle());
        result.setBookGenres(refList(book.getBookGenres(), this::getBookGenre));
        return result;
    }


}
