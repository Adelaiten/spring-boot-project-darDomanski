package com.codecool.BookShop.repository;

import com.codecool.BookShop.model.BookForm;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface BookFormRepository extends JpaRepository<BookForm, Long >  {





}
