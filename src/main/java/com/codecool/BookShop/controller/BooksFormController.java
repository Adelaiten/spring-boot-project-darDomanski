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

//        @DeleteMapping("/bookForm/{id}")
//        public void deleteBooksForm(@PathVariable long id) {
//            bookFormService.deleteById(id);
//        }

        @DeleteMapping("/bookForm/{id}")
        public String deleteBooksForm(@PathVariable Long id) {
            if(bookFormService.existsById(id)) {
                bookFormService.deleteById(id);
                return "deleted";
            }
            return "bookForm do not exist in database!";
        }

//        @PostMapping("/bookForm")
//        public ResponseEntity<Object> createBookForm(@RequestBody BookForm bookForm) {
//            BookForm savedBookForm = bookFormService.save(bookForm);
//            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                    .buildAndExpand(savedBookForm.getId()).toUri();
//            return ResponseEntity.created(location).build();
//        }

        @PostMapping("/bookForm")
        public BookForm createBookForm(@RequestBody BookForm bookForm) {
            Long bookFormId = bookForm.getId();
            if( bookFormId != null && bookFormService.existsById( bookFormId ) ) {
                return null;
            }
            bookForm.setId( null );
            return bookFormService.save( bookForm );
        }

        @PutMapping("/bookForm")
        public BookForm updateBookForm(@RequestBody BookForm bookForm) {
            return bookFormService.save(bookForm);
        }


}
