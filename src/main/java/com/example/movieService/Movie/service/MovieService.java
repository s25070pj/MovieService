package com.example.movieService.Movie.service;

import com.example.movieService.Movie.Model.Movie;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final List<Movie> movies = new ArrayList<>();

    public MovieService() {
        movies.add(new Movie(1, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy"));
        movies.add(new Movie(2, "The Conjuring", "Horror"));
        movies.add(new Movie(3, "Fast and Furious: Tokyo Drift", "Action"));
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }



}