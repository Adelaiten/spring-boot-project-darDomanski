package com.codecool.BookShop.controller;

import com.codecool.BookShop.model.*;
import com.codecool.BookShop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private BookFormService bookFormService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public List<Book> retrieveAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> retrieveBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        checkIfGenreExists(book);
        checkIfBookFormExists(book);
        checkIfAuthorExists(book);

        return bookService.save(book);
    }

    private void checkIfAuthorExists(@RequestBody Book book) {
        List<Author> authors = book.getAuthors();
        for(int i = 0; i < authors.size(); i++) {
            Author author = authors.get(i);
            String authorName = authors.get(i).getName().toLowerCase();
            String authorSurname = authors.get(i).getSurname().toLowerCase();
            author.setName(authorName);
            author.setSurname(authorSurname);
            List<Author> dbAuthors = authorService.getAuthorsByNameAndSurname(authorName, authorSurname);
            setAuthorIfAuthorListLongerThanOne(authors, i, dbAuthors);

        }
    }

    private void setAuthorIfAuthorListLongerThanOne(List<Author> authors, int i, List<Author> dbAuthors) {
        if(dbAuthors.size() > 0) {
            Author dbAuthor = dbAuthors.get(0);
            authors.set(i, dbAuthor);
        }
    }

    private void checkIfBookFormExists(@RequestBody Book book) {
        List<BookForm> bookForms = book.getBookForm();
        for(int i = 0; i < bookForms.size(); i++) {
            String bookFormName = bookForms.get(i).getForm().toLowerCase();
            book.getBookForm().get(i).setForm(bookFormName);
            List<BookForm>  dbBookForms = new ArrayList<>();
            dbBookForms = getBookFormsByForm(bookFormName, dbBookForms);

            setBookFormIfBookFormListLongerThanOne(bookForms, i, dbBookForms);
        }
    }

    private List<BookForm> getBookFormsByForm(String bookFormName, List<BookForm> dbBookForms) {
        try{
            dbBookForms = bookFormService.getBookFormsByForm(bookFormName);
        }catch(NullPointerException e) {
            e.printStackTrace();
        }
        return dbBookForms;
    }

    private void setBookFormIfBookFormListLongerThanOne(List<BookForm> bookForms, int i, List<BookForm> dbBookForms) {
        if(dbBookForms.size() > 0) {
            BookForm bookForm = dbBookForms.get(0);
            bookForms.set(i, bookForm);
        }
    }

    private void checkIfGenreExists(@RequestBody Book book) {
        String genreName = book.getGenre().getGenre().toLowerCase();
        book.getGenre().setGenre(genreName);
        List<Genre> genres = new ArrayList<>();
        genres = getGenreByGenreName(genreName, genres);
        setGenreIfGenreListLongerThanOne(book, genres);
    }


    private void setGenreIfGenreListLongerThanOne(@RequestBody Book book, List<Genre> genres) {
        if(genres.size() > 0) {
            book.setGenre(genres.get(0));
        }
    }

    private List<Genre> getGenreByGenreName(String genreName, List<Genre> genres) {
        try{
           genres = genreService.getGenreByGenreName(genreName);
        }catch (NullPointerException e){
            System.out.println("Genre does not exist in database");
        }
        return genres;
    }


}
