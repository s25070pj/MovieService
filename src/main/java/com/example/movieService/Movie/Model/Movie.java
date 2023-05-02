package com.example.movieService.Movie.Model;


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
        this.description = "";
        this.releaseYear = 0;
    }

    public Movie() {
        this.id = 0;
        this.name = "";
        this.category = "";
        this.description = "";
        this.releaseYear = 0;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
