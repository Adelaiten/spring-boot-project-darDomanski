package com.codecool.BookShop.service;

import com.codecool.BookShop.model.BookForm;
import com.codecool.BookShop.model.Genre;
import com.codecool.BookShop.repository.BookFormRepository;
import com.codecool.BookShop.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;


    public List<Genre> findAll(){
        return genreRepository.findAll();
    }

    public Optional<Genre> findById(Long id){
        return genreRepository.findById(id);
    }

    public void deleteById(Long id){
        genreRepository.deleteById(id);
    }

    public Genre save ( Genre genre ) {
        genreRepository.save( genre);
        return genre;
    }

    public boolean existsById(Long id) {
        return genreRepository.existsById(id);
    }


}
