package com.codecool.BookShop.repository;

import com.codecool.BookShop.model.ArchivedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchivedBookRepository extends JpaRepository<ArchivedBook, Long> {
}
