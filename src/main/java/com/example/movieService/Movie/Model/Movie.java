package com.example.movieService.Movie.Model;

import com.sun.jdi.event.StepEvent;

public class Movie {
    private int id;
    private String name;
    private String category;
    private String description;
    private int releaseYear;

    public Movie(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription(){
        return description;
    }

    public int getReleaseYear(){
        return releaseYear;
    }

    public void setId(int id) {
        this.id = id;
    }
}
