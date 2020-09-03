package com.makimenko.fs.domain.book;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class BookSearchFilter {

    private String title;

    private List<UUID> authors;

    private List<String> bookGenres;

}
