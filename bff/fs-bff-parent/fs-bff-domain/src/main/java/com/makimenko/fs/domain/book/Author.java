package com.makimenko.fs.domain.book;

import com.makimenko.fs.domain.Person;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@ToString(callSuper = true)
public class Author extends Person {

    private String licenseId;

}
