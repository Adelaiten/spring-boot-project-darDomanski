package com.codecool.BookShop.controller;

import com.codecool.BookShop.model.*;
import com.codecool.BookShop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;


@RestController
public class BooksFormController {

        @Autowired
        private BookFormRepository bookFormRepository;

        @GetMapping("/bookForm")
        public List<BookForm> retrieveAllbooksForm() {
            return bookFormRepository.findAll();
        }

        @GetMapping("/bookForm/{id}")
//        public BookForm retrieveBookForm(@PathVariable long id) {
//            Optional< BookForm > bookform = bookFormRepository.findById(id);
//            if (!bookform.isPresent())
//                throw new StudentNotFoundException("id-" + id);
//            return bookform.get();
//        }

        @DeleteMapping("/bookForm/{id}")
        public void deleteBooksFOrm(@PathVariable long id) {
            bookFormRepository.deleteById(id);
        }

        @PostMapping("/bookForm")
        public ResponseEntity<Object> createBookForm(@RequestBody BookForm bookForm) {
            BookForm savedBookForm = bookFormRepository.save(bookForm);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(savedBookForm.getId()).toUri();

            return ResponseEntity.created(location).build();

        }


}
