package com.codecool.BookShop.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @ManyToMany
    private List<Author> authors;
    @OneToOne
    private Genre genre;
    @OneToOne
    private Publisher publisher;
    private Date releaseDate;
    private Double price;
    private Integer inStockAmount;
    @ManyToMany
    private List<BookForm>bookForm;

    protected Book(){}

    public Book(String title, List<Author> authors, Genre genre, Publisher publisher, Date releaseDate, double price, int inStockAmount, List<BookForm> bookForm) {
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

    public List<BookForm> getBookForm() {
        return bookForm;
    }

    public void setBookForm(List<BookForm> bookForm) {
        this.bookForm = bookForm;
    }
}
