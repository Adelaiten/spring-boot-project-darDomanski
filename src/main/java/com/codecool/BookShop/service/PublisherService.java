package com.codecool.BookShop.service;

import com.codecool.BookShop.model.Publisher;
import com.codecool.BookShop.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;


    public List<Publisher> findAll(){
        return publisherRepository.findAll();
    }

    public Optional<Publisher> findById(Long id){
        return publisherRepository.findById(id);
    }

    public void deleteById(Long id){
        publisherRepository.deleteById(id);
    }

    public Publisher save ( Publisher publisher ) {
        publisherRepository.save( publisher);
        return publisher;
    }

    public List<Publisher> getPublishersByPublisherNameAndCountry(String publisherName, String country) {
        return publisherRepository.getPublishersByPublisherNameAndCountry(publisherName, country);
    }
    public boolean existsById(Long id) {
        return publisherRepository.existsById(id);
    }


}
