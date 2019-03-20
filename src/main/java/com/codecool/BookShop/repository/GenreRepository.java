package com.codecool.BookShop.repository;

import com.codecool.BookShop.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query(value = "SELECT * FROM genres WHERE genre_name = :genreName", nativeQuery = true)
    List<Genre> getGenresByGenreName(@Param("genreName") String genreName);

}
