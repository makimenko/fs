package com.makimenko.fs.persistence.mongodb.entity;


import com.makimenko.fs.common.domain.book.Book;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@NoArgsConstructor
@Data
public class BookEntity extends BusinessEntity<Book> {

    public BookEntity(Book book) {
        this.updateEntity(book);
    }

    @Id
    UUID id;

    String title;


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
