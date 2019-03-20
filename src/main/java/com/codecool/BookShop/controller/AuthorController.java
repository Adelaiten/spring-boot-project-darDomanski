package com.codecool.BookShop.controller;

import com.codecool.BookShop.model.Author;
import com.codecool.BookShop.repository.AuthorRepository;
import com.codecool.BookShop.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> retrieveAllAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/author/{id}")
    public Optional<Author> retrieveAuthorById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @PostMapping("/author")
    public Author addAuthor(@RequestBody Author author) {
        Long authorId = author.getId();
        if(authorId != null && authorService.existsById(authorId)) {
            return null;
        }
        author.setId(null);
        return authorService.save(author);
    }

    @PutMapping("/author")
    public Author updateAuthor(@RequestBody Author author) {
        return authorService.save(author);
    }

    @DeleteMapping("/author/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        if(authorService.existsById(id)) {
            authorService.deleteById(id);
            return "deleted";
        }
        return "author do not exist in database!";
    }




}
