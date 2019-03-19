package com.codecool.BookShop.controller;

import com.codecool.BookShop.model.*;
import com.codecool.BookShop.repository.*;
import com.codecool.BookShop.service.BookFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;


@RestController
public class BooksFormController {

        @Autowired
        private BookFormService bookFormService;

        @GetMapping("/bookForm")
        public List<BookForm> retrieveAllbooksForm() {
            return bookFormService.findAll();
        }

        @GetMapping("/bookForm/{id}")
        public BookForm retrieveBookForm(@PathVariable long id) {
            Optional< BookForm > bookform = bookFormService.findById(id);
//            if (!bookform.isPresent())
//                throw new StudentNotFoundException("id-" + id);
            return bookform.get();
        }

        @DeleteMapping("/bookForm/{id}")
        public void deleteBooksFOrm(@PathVariable long id) {
            bookFormService.deleteById(id);
        }

        @PostMapping("/bookForm")
        public ResponseEntity<Object> createBookForm(@RequestBody BookForm bookForm) {
            BookForm savedBookForm = bookFormService.save(bookForm);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(savedBookForm.getId()).toUri();

            return ResponseEntity.created(location).build();

        }


}
