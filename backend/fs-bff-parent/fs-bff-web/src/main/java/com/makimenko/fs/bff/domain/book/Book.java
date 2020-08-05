package com.makimenko.fs.bff.domain.book;

import com.makimenko.fs.bff.domain.BusinessData;

import java.time.LocalDate;

public class Book extends BusinessData {

    private String title;
    private Author author;
    private Genre genres[];
    private int avgRank;
    private LocalDate releaseDate;

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre[] getGenres() {
        return genres;
    }

    public void setGenres(Genre[] genres) {
        this.genres = genres;
    }

    public int getAvgRank() {
        return avgRank;
    }

    public void setAvgRank(int avgRank) {
        this.avgRank = avgRank;
    }

}
