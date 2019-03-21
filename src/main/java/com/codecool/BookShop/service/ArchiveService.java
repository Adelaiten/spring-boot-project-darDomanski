package com.codecool.BookShop.service;

import com.codecool.BookShop.model.ArchivedBook;
import com.codecool.BookShop.repository.ArchivedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveService {

    @Autowired
    private ArchivedBookRepository archivedBookRepository;

    public List<ArchivedBook> findAll() {
        return archivedBookRepository.findAll();
    }

    public ArchivedBook findById(long id) {
        return archivedBookRepository.getOne(id);
    }

    public void deleteById(long id) {
        archivedBookRepository.deleteById(id);
    }


}
