package com.codecool.BookShop.controller;

import com.codecool.BookShop.model.Genre;
import com.codecool.BookShop.model.Publisher;
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
        public List<Publisher> retrieveAllPublisher() {
            return publisherService.findAll();
        }

        @GetMapping("/publisher/{id}")
        public Publisher retrievePublisher(@PathVariable long id) {
            Optional<Publisher> publisher = publisherService.findById(id);
//            if (!bookform.isPresent())
//                throw new PublisherNotFoundException("id-" + id);
            return publisher.get();
        }

        @DeleteMapping("/publisher/{id}")
        public void deletePublisher(@PathVariable long id) {
            publisherService.deleteById(id);
        }

        @PostMapping("/publisher")
        public ResponseEntity<Object> createPublisher(@RequestBody Publisher publisher) {
            Publisher savedPublisher = publisherService.save(publisher);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(savedPublisher.getId()).toUri();
            return ResponseEntity.created(location).build();
        }

        @PutMapping("/publisher")
        public Publisher updatePublisher(@RequestBody Publisher publisher) {
            return publisherService.save( publisher );
        }

}
