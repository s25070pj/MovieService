package com.example.movieService.Movie.service;

import com.example.movieService.Movie.Interface.MovieRepository;
import com.example.movieService.Movie.Model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void addMovie(Movie movie) {
         movieRepository.save(movie);
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void updateMovie(Long id, Movie movie) {
            Movie existingMovie = this.movieRepository.findById(id).get();
        if (!movie.getName().isEmpty()) {
            existingMovie.setName(movie.getName());
        }
        if (!movie.getCategory().isEmpty()) {
            existingMovie.setCategory(movie.getCategory());
        }
        if (!movie.getDescription().isEmpty()) {
            existingMovie.setDescription(movie.getDescription());
        }
        if (movie.getReleaseYear() != 0) {
            existingMovie.setReleaseYear(movie.getReleaseYear());
        }
        if (movie.isAvailable()) {
            existingMovie.setAvailable(movie.isAvailable());
        }
         movieRepository.save(movie);
    }

    public void updateAvailableStatus(Long id, boolean status){
        movieRepository.updateAvailableStatus(id, status);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
