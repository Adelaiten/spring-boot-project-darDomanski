package com.codecool.BookShop.service;

import com.codecool.BookShop.model.BookForm;
import com.codecool.BookShop.repository.BookFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookFormService  {

    @Autowired
    private BookFormRepository bookFormRepository;


    public List<BookForm> findAll(){
        return bookFormRepository.findAll();
    }

    public Optional<BookForm> findById(Long id){
        return bookFormRepository.findById(id);
    }

    public void deleteById(Long id){
        bookFormRepository.deleteById(id);
    }

    public BookForm save(BookForm bookForm ) {
        bookFormRepository.save(bookForm);
        return bookForm;
    }

    public boolean existsById(Long id) {
        return bookFormRepository.existsById(id);
    }

    public List<BookForm> myOwnQuery(){
        List<BookForm> forms = bookFormRepository.myOwnQuery();
        return forms;
    }


}
