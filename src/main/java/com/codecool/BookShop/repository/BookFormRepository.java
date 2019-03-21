package com.codecool.BookShop.repository;

import com.codecool.BookShop.model.BookForm;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookFormRepository extends JpaRepository<BookForm, Long >  {

    @Query(value="SELECT * FROM book_forms WHERE form = :form", nativeQuery = true)
    List<BookForm> getBookFormsByForm(@Param("form") String form);



}
