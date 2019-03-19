package com.codecool.BookShop.controller;

import com.codecool.BookShop.model.Genre;
import com.codecool.BookShop.service.GenreService;
import com.codecool.BookShop.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class PublisherController {

        @Autowired
        private PublisherService publisherService;

        @GetMapping("/publisher")
        public List<Genre> retrieveAllgenreForm() {
            return publisherService.findAll();
        }

        @GetMapping("/publisher/{id}")
        public Genre retrieveBookForm(@PathVariable long id) {
            Optional< Genre > genre = publisherService.findById(id);
//            if (!bookform.isPresent())
//                throw new PublisherNotFoundException("id-" + id);
            return genre.get();
        }

        @DeleteMapping("/publisher/{id}")
        public void deleteGenre(@PathVariable long id) {
            publisherService.deleteById(id);
        }

        @PostMapping("/publisher")
        public ResponseEntity<Object> createGenre(@RequestBody Genre genre) {
            Genre savedGenre = publisherService.save(genre);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(savedGenre.getId()).toUri();
            return ResponseEntity.created(location).build();
        }


}
