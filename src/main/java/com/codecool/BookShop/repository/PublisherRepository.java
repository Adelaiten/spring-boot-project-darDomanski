package com.codecool.BookShop.repository;

import com.codecool.BookShop.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    @Query(value="SELECT * FROM publishers WHERE publisher_name = :publisherName AND country = :country", nativeQuery = true)
    List<Publisher> getPublishersByPublisherNameAndCountry(@Param("publisherName") String publisherName, @Param("country") String country);
}
