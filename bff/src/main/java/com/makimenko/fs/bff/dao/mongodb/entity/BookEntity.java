package com.makimenko.fs.bff.dao.mongodb.entity;

import com.makimenko.fs.bff.domain.book.Book;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public class BookEntity extends BusinessEntity<Book> {

    public BookEntity() {

    }

    public BookEntity(Book book) {
        this.updateEntity(book);
    }

    @Id
    UUID id;

    String title;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Book toDomain() {
        Book book = new Book();
        book.setId(this.id);
        book.setTitle(this.title);
        // TODO: update all fields
        return book;
    }

    @Override
    public void updateEntity(Book dom) {
        this.id = (dom.getId() != null ? dom.getId() : UUID.randomUUID());
        this.title = dom.getTitle();
        // TODO: update all fields
    }

}
