package com.makimenko.fs.web.service.book;

import com.makimenko.fs.domain.book.Author;
import com.makimenko.fs.domain.book.AuthorList;
import com.makimenko.fs.persistence.repository.AuthorRepository;
import com.makimenko.fs.web.service.ServiceException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<AuthorList> find(Author filter) {
        return authorRepository.findAuthorList()
                .stream()
                .map(this::toAuthorList)
                .collect(Collectors.toList());
    }

    @Override
    public Author get(ObjectId id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Author not found by id: " + id));
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    private AuthorList toAuthorList(Author author) {
        AuthorList result = new AuthorList();
        result.setId(author.getId());
        result.setName(author.getName());
        return result;
    }

}
