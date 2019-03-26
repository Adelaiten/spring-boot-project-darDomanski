package com.codecool.BookShop.service;

import com.codecool.BookShop.model.Book;
import com.codecool.BookShop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    public Book getOne(Long id) {
        return bookRepository.getOne(id);
    }


    public Book save(Book book) {
        return bookRepository.save(book);
    }


    public List<Book> getBooksByPrice (Integer price )  {
        return bookRepository.getBookByPrice( price );
    }


    public List<Book>  getBooksByAmount (Integer amount )  {
        return bookRepository.getBooksByAmount( amount );
    }


    public List<Book> getBooksByADate (Date date1, Date date2  ) {
        return bookRepository.getBooksByADate( date1, date2 );
    }


    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }


    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
}
