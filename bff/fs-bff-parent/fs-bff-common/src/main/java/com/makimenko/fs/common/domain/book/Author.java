package com.makimenko.fs.common.domain.book;

import com.makimenko.fs.common.domain.Person;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Author extends Person {

    String licenseId;
    Genre genre;

    public static void main(String[] args) {

    }

}
