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
    private BookFormService bookFormService;

//    public List<BookForm> retrieveAllbooksForm() {
////        return bookFormRepository.findAll();
////    }

    public List<BookForm> findAll(){
        return bookFormService.findAll();
    }

    public Optional<BookForm> findById(Long id){
        return bookFormService.findById(id);
    }

    public void deleteById(Long id){
        bookFormService.deleteById(id);
    }

    public BookForm save(BookForm bookForm ) {
        bookFormService.save(bookForm);
        return bookForm;
    }


}
