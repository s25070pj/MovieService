package com.example.movieService.Movie.Interface;

import com.example.movieService.Movie.Model.Movie;
import jakarta.persistence.NamedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {



    @Query("SELECT m FROM Movie m")
    List<Movie> findAllMovies();

    @Query("SELECT m FROM Movie m WHERE m.id = :id")
    Optional<Movie> findById(@Param("id") Long id);

    @Query(value = "INSERT INTO Movie (name, category, description, release_year, is_available) " +
            "VALUES (:#{#movie.name}, :#{#movie.category}, :#{#movie.description}, :#{#movie.releaseYear}, :#{#movie.available})", nativeQuery = true)
    @Modifying
    @Transactional
    void addMovie(@Param("movie") Movie movie);


    @Query("UPDATE Movie m SET m.name = :#{#movie.name}, m.category = :#{#movie.category}, " +
            "m.description = :#{#movie.description}, m.releaseYear = :#{#movie.releaseYear}, m.isAvailable = :#{#movie.available} WHERE m.id = :id")
    @Modifying
    @Transactional
    void updateMovie(@Param("id") Long id, @Param("movie") Movie movie);

    @Query("update Movie m set m.isAvailable = :status where m.id = :id")
    @Modifying
    @Transactional
    void updateAvailableStatus(Long id, boolean status);

    @Query("DELETE FROM Movie m WHERE m.id = :id")
    @Modifying
    @Transactional
    void deleteMovie(@Param("id") Long id);


}
