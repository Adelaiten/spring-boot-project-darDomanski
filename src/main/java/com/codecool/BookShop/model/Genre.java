package com.codecool.BookShop.model;

public class Genre {
    private long id;
    private String genre;

    protected Genre(){}


    public Genre(long id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
