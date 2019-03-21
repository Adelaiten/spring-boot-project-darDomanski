package com.codecool.BookShop.repository;

import com.codecool.BookShop.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

//    void saveAll(List<Publisher> publisher);

}



