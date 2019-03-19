package com.codecool.BookShop.service;

import com.codecool.BookShop.model.Author;
import com.codecool.BookShop.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }
}
