package com.makimenko.fs.common.domain.book;

import com.makimenko.fs.common.domain.BusinessData;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Book extends BusinessData {

    private String title;
    private Author author;
    private Genre genres[];
    private int avgRank;
    private LocalDate releaseDate;

}
