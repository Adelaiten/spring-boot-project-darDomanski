package com.codecool.BookShop.controller;

import com.codecool.BookShop.model.Author;
import com.codecool.BookShop.model.Book;
import com.codecool.BookShop.model.BookForm;
import com.codecool.BookShop.model.Genre;
import com.codecool.BookShop.repository.BookFormRepository;
import com.codecool.BookShop.repository.BookRepository;
import com.codecool.BookShop.repository.GenreRepository;
import com.codecool.BookShop.service.AuthorService;
import com.codecool.BookShop.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    GenreService genreService;

    @Autowired
    BookFormRepository bookFormRepository;

    @GetMapping("/books")
    public List<Book> retrieveAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> retrieveBookById(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        checkIfGenreExists(book);
        List<BookForm> bookForms = book.getBookForm();
        for(int i = 0; i < bookForms.size(); i++) {
            String bookFormName = bookForms.get(i).getForm().toLowerCase();
            book.getBookForm().get(i).setForm(bookFormName);
            List<BookForm>  dbBookForms = new ArrayList<>();
            dbBookForms = getBookFormsByForm(bookFormName, dbBookForms);

            setBookFormIfBookFormListLongerThanOne(bookForms, i, dbBookForms);
        }

        return bookRepository.save(book);
    }

    private List<BookForm> getBookFormsByForm(String bookFormName, List<BookForm> dbBookForms) {
        try{
            dbBookForms = bookFormRepository.getBookFormsByForm(bookFormName);
        }catch(NullPointerException e) {
            e.printStackTrace();
        }
        return dbBookForms;
    }

    private void setBookFormIfBookFormListLongerThanOne(List<BookForm> bookForms, int i, List<BookForm> dbBookForms) {
        BookForm bookForm;
        if(dbBookForms.size() > 0) {
            bookForm = dbBookForms.get(0);
            bookForms.set(i, bookForm);
        }
    }

    private void checkIfGenreExists(@RequestBody Book book) {
        String genreName = book.getGenre().getGenre().toLowerCase();
        book.getGenre().setGenre(genreName);
        Genre genre = null;
        List<Genre> genres = new ArrayList<>();
        genres = getGenreByGenreName(genreName, genres);
        genre = setGenreIfGenreListLongerThanOne(book, genre, genres);

    }


    private Genre setGenreIfGenreListLongerThanOne(@RequestBody Book book, Genre genre, List<Genre> genres) {
        if(genres.size() > 0) {
            genre = genres.get(0);
            book.setGenre(genre);
        }
        return genre;
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
