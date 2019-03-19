package com.codecool.BookShop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_forms")
public class BookForm {
    @Id
    @GeneratedValue
    private long id;
    private String form;

    protected BookForm() {}

    public BookForm(String form) {
        this.id = id;
        this.form = form;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}
