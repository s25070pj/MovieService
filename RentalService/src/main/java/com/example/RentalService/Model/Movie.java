package com.example.RentalService.Model;

public class Movie {

    private Long id;
    private String name;
    private String category;
    private String description;
    private int releaseYear;

    private boolean isAvailable = false;


    public Movie(String name, String category) {
        this.name = name;
        this.category = category;
        this.description = "";
        this.releaseYear = 0;
        this.isAvailable = false;
    }


    public Movie() {
        this.name = "";
        this.category = "";
        this.description = "";
        this.releaseYear = 0;
        this.isAvailable = false;
    }

    public void setId(Long id) {
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

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}