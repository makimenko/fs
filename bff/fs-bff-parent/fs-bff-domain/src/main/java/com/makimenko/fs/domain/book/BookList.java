package com.makimenko.fs.domain.book;

import com.makimenko.fs.domain.BusinessData;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class BookList extends BusinessData {

    private String title;

    private List<BookGenre> bookGenres;

}
