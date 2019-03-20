package com.codecool.BookShop.controller;

import com.codecool.BookShop.model.Book;
import com.codecool.BookShop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

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
        return bookRepository.save(book);
    }


}
