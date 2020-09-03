package com.makimenko.fs.domain.book;

import com.makimenko.fs.domain.BusinessData;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@NoArgsConstructor
@Data
public class Book extends BusinessData {

    private String title;

    private List<String> authors;

    private List<String> bookGenres;

    private int avgRank;

    private LocalDate releaseDate;

}
