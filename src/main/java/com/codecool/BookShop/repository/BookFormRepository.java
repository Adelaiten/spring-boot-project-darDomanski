package com.codecool.BookShop.repository;

import com.codecool.BookShop.model.BookForm;
import com.codecool.BookShop.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookFormRepository extends JpaRepository< BookForm, Long >  {

//    @Query("Select e from BookForm e WHERE e.form like 'cafff'")
//    List<BookForm> myOwnQuery();


}
