package com.codecool.BookShop.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "archive")
public class ArchivedBook extends Book {
    @Temporal(TemporalType.DATE)
    private Date archiveDate;

    public ArchivedBook() {
    }

    public ArchivedBook(String title, List<Author> authors, Genre genre, Publisher publisher, Date releaseDate, double price, int inStockAmount, List<BookForm> bookForm) {
        super(title, authors, genre, publisher, releaseDate, price, inStockAmount, bookForm);
        this.archiveDate = new Date();
    }
}
