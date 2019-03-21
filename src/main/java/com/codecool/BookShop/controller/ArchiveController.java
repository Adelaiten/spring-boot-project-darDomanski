package com.codecool.BookShop.controller;

import com.codecool.BookShop.model.ArchivedBook;
import com.codecool.BookShop.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArchiveController {

    @Autowired
    private ArchiveService archiveService;

    @GetMapping("/secured/archive")
    public List<ArchivedBook> getAll() {
        return archiveService.findAll();
    }

    @GetMapping("/secured/archive/{id}")
    public ArchivedBook getById(@PathVariable("id") long id) {
        return archiveService.findById(id);
    }

    @DeleteMapping("/secured/archive/{id}")
    public void deleteById(@PathVariable("id") long id) {
        archiveService.deleteById(id);
    }

}
