package com.codecool.BookShop.repository;

import com.codecool.BookShop.model.Book;
import com.codecool.BookShop.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findById(Long id);

    @Query(value="SELECT * FROM books u WHERE u.price > :price", nativeQuery = true)
    List<Book> getBookByPrice(@Param("price") Integer price );

    @Query(value="SELECT * FROM books u WHERE u.in_stock_amount > :amount", nativeQuery = true)
    List<Book> getBooksByAmount(@Param("amount") Integer price );


    @Query(value="SELECT * FROM books u WHERE u.release_date between :date1 and :date2  ", nativeQuery = true)
    List<Book> getBooksByADate(@Param("date1") Date date1, @Param("date2") Date date2 );





}


