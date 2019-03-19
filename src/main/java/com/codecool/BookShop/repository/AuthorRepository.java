package com.codecool.BookShop.repository;

import com.codecool.BookShop.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
