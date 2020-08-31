package com.makimenko.fs.domain.book;

import com.makimenko.fs.domain.BusinessData;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class Book extends BusinessData {

    private String title;
    private Author author;
    private BookGenre bookGenres[];
    private int avgRank;
    private LocalDate releaseDate;

}