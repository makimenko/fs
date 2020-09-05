package com.makimenko.fs.web.service.book;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@NoArgsConstructor
public class BookSearchFilter {

    private String title;

    private List<ObjectId> authors;

    private List<String> bookGenres;

}
