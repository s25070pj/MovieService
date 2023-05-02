package com.example.movieService.Movie.controller;

import com.example.movieService.Movie.Model.Movie;
import com.example.movieService.Movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class MovieController {

    private final MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        if (!movieService.getAllMovies().isEmpty()) {
            return ResponseEntity.ok(movieService.getAllMovies());
        } else {
            return  ResponseEntity.noContent().build(); //if list is empty - 204
        }
    }
    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id){
        if(movieService.getMovieById(id) != null){
            return ResponseEntity.ok(movieService.getMovieById(id));
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
