package com.codecool.BookShop.repository;

import com.codecool.BookShop.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
