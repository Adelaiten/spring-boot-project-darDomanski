package com.codecool.BookShop.model;

public class BookForm {
    private int id;
    private String form;

    protected BookForm() {}

    public BookForm(int id, String form) {
        this.id = id;
        this.form = form;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}
