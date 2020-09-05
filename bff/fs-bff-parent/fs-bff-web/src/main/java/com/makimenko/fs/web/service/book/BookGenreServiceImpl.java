package com.makimenko.fs.web.service.book;

import com.makimenko.fs.domain.book.BookGenre;
import com.makimenko.fs.persistence.repository.BookGenreRepository;
import com.makimenko.fs.web.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookGenreServiceImpl implements BookGenreService {

    @Autowired
    private BookGenreRepository bookGenreRepository;

    @Override
    public List<BookGenre> find(BookGenre template) {
        return bookGenreRepository.findAll();
    }

    @Override
    public BookGenre get(String id) {
        return bookGenreRepository.findById(id)
                .orElseThrow(() -> new ServiceException("BookGenre not found: " + id));
    }

    @Override
    public BookGenre save(BookGenre bookGenre) {
        return bookGenreRepository.save(bookGenre);
    }
}
