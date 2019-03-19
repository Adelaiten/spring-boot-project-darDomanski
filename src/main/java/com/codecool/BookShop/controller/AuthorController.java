package com.codecool.BookShop.controller;

import com.codecool.BookShop.model.Author;
import com.codecool.BookShop.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/authors")
    public List<Author> retrieveAllAuthors() {
        return authorRepository.findAll();
    }

    @PostMapping("/author")
    public Author addAuthor(@RequestBody Author author) {
        Long authorId = author.getId();
        if(authorId != null && authorRepository.existsById(authorId)) {
            return null;
        }
        author.setId(null);
        return authorRepository.save(author);
    }

    @PutMapping("/author")
    public Author updateAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }
}
