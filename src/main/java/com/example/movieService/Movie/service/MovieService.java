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

    public void updateMovie(Movie movieWithUpdatedData){
        Movie movieInBase = getMovieById(movieWithUpdatedData.getId());
        if(movieInBase != null){
            if(movieWithUpdatedData.getName() != null){
                movieInBase.setName(movieWithUpdatedData.getName());
            }
            if(movieWithUpdatedData.getCategory() != null){
                movieInBase.setCategory(movieWithUpdatedData.getCategory());
            }
            if(movieWithUpdatedData.getDescription() != null){
                movieInBase.setDescription(movieWithUpdatedData.getDescription());
            }
            if (movieWithUpdatedData.getReleaseYear() >= 1888){
                movieInBase.setReleaseYear(movieWithUpdatedData.getReleaseYear());
            }else{
                throw new IllegalArgumentException("Zły rok wydania, pierwszy film powstał w 1888roku");
            }
        }else {
            throw new IllegalArgumentException("Nie udało sie zaktualizować, film o id " + movieWithUpdatedData.getId() + " nie został odnaleziony w bazie");
        }
    }

    public void deleteMovie(int id){
        Movie movieToDelete = getMovieById(id);
        if (movieToDelete != null){
            movies.remove(movieToDelete);
        }else {
            throw new IllegalArgumentException("Nie udało się usunąć, film o id " + id + " nie został odnaleziony w bazie");
        }
    }

}
