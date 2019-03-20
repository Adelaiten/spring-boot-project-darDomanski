package com.codecool.BookShop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue
    private long id;
    private String genreName;

    protected Genre(){}


    public Genre(String genreName) {
        this.id = id;
        this.genreName = genreName;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genreName;
    }

    public void setGenre(String genre) {
        this.genreName = genre;
    }
}
