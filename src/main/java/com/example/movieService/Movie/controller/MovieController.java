package com.example.movieService.Movie.controller;

import com.example.movieService.Movie.Model.Movie;
import com.example.movieService.Movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        if (!movieService.getAllMovies().isEmpty()) {
            return ResponseEntity.ok(movieService.getAllMovies());
        } else {
            return ResponseEntity.noContent().build(); //if list is empty - 204
        }
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id) {
        Optional<Movie> movie = movieService.findById(id);
        if (movie.isPresent()) {
            return ResponseEntity.ok(movie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        if (movie != null) {
            movieService.addMovie(movie);
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        if (findById(id) != null) {
            movieService.updateMovie(id, movie);
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/movies/change/{id}")
    public ResponseEntity<Movie> updateAvailableStatus(@PathVariable Long id, @RequestBody boolean status){
        if (findById(id) != null){
            movieService.updateAvailableStatus(id, status);
            return ResponseEntity.ok(findById(id).getBody());
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        if(findById(id) != null){
            movieService.deleteMovie(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
