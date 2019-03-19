package com.codecool.BookShop.controller;

import com.codecool.BookShop.model.Genre;
import com.codecool.BookShop.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class GenreController {

        @Autowired
        private GenreService genreService;

        @GetMapping("/genre")
        public List<Genre> retrieveAllgenreForm() {
            return genreService.findAll();
        }

        @GetMapping("/genre/{id}")
        public Genre retrieveBookForm(@PathVariable long id) {
            Optional< Genre > genre = genreService.findById(id);
//            if (!bookform.isPresent())
//                throw new StudentNotFoundException("id-" + id);
            return genre.get();
        }

        @DeleteMapping("/genre/{id}")
        public void deleteGenre(@PathVariable long id) {
            genreService.deleteById(id);
        }

        @PostMapping("/genre")
        public ResponseEntity<Object> createGenre(@RequestBody Genre genre) {
            Genre savedGenre = genreService.save(genre);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(savedGenre.getId()).toUri();
            return ResponseEntity.created(location).build();
        }


}
