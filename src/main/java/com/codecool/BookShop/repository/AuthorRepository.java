package com.codecool.BookShop.repository;

import com.codecool.BookShop.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "SELECT * FROM authors WHERE name = :name AND surname = :surname", nativeQuery = true)
    List<Author> getAuthorsByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}

