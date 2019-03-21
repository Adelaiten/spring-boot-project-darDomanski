package com.codecool.BookShop.controller;

import com.codecool.BookShop.model.*;
import com.codecool.BookShop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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
        checkIfPublisherExists(book);
        return bookService.save(book);
    }

    private void checkIfPublisherExists(@RequestBody Book book) {
        Publisher publisher = book.getPublisher();
        String publisherName = publisher.getPublisherName().toLowerCase();
        String publisherCountry = publisher.getCountry().toLowerCase();
        publisher.setPublisherName(publisherName);
        publisher.setCountry(publisherCountry);
        List<Publisher> dbPublishers = publisherService.getPublishersByPublisherNameAndCountry(publisherName, publisherCountry);
        setPublisherIfPublisherListLongerThanOne(book, dbPublishers);
    }

    private void setPublisherIfPublisherListLongerThanOne(@RequestBody Book book, List<Publisher> dbPublishers) {
        if(dbPublishers.size() > 0) {
            Publisher dbPublisher = dbPublishers.get(0);
            book.setPublisher(dbPublisher);
        }
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
            List<BookForm> dbBookForms = bookFormService.getBookFormsByForm(bookFormName);

            setBookFormIfBookFormListLongerThanOne(bookForms, i, dbBookForms);
        }
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


    @GetMapping("/books/price>/{price}")
    public List<Book> getBooksByPrice(@PathVariable Integer price) {
        return bookService.getBooksByPrice(price);
    }

    @GetMapping("/books/amount>/{amount}")
    public List<Book> getBooksByAmount(@PathVariable Integer amount) {
        return bookService.getBooksByAmount(amount);
    }

    @GetMapping("/books/release/{date1},{date2}")
    public List<Book> getBooksByADate(@PathVariable Date date1, @PathVariable Date date2) {
        return bookService.getBooksByADate(date1,date2);
    }




}
