package com.codecool.BookShop.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class BookForm {
    @Id
    @GeneratedValue
    private long id;
    private String form;

    protected BookForm() {}

    public BookForm(long id, String form) {
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
