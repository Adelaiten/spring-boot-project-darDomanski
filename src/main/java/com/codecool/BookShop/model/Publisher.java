package com.codecool.BookShop.model;

public class Publisher {
    private long id;
    private String publisherName;
    private String country;

    protected Publisher() {}

    public Publisher(int id, String publisherName, String country) {
        this.id = id;
        this.publisherName = publisherName;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
