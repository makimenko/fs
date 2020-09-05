package com.makimenko.fs.web.service.book;

import com.makimenko.fs.domain.book.Author;
import com.makimenko.fs.persistence.repository.AuthorRepository;
import com.makimenko.fs.web.service.ServiceException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author getAuthor(ObjectId id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Author not found by id: " + id));
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

}
