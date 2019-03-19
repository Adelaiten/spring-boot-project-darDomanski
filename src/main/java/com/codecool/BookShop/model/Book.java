package com.codecool.BookShop.model;

import java.util.Date;
import java.util.List;

public class Book {
    private long id;
    private String title;
    private List<Author> authors;
    private Genre genre;
    private Publisher publisher;
    private Date releaseDate;
    private double price;
    private int inStockAmount;
    private BookForm bookForm;

    protected Book(){}

    public Book(long id, String title, List<Author> authors, Genre genre, Publisher publisher, Date releaseDate, double price, int inStockAmount, BookForm bookForm) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.genre = genre;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.price = price;
        this.inStockAmount = inStockAmount;
        this.bookForm = bookForm;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInStockAmount() {
        return inStockAmount;
    }

    public void setInStockAmount(int inStockAmount) {
        this.inStockAmount = inStockAmount;
    }

    public BookForm getBookForm() {
        return bookForm;
    }

    public void setBookForm(BookForm bookForm) {
        this.bookForm = bookForm;
    }
}
