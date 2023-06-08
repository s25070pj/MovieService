package com.example.RentalService.Service;

import com.example.RentalService.Model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RentalService {

    private final RestTemplate restTemplate;

    @Autowired
    public RentalService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public Movie getMovie(Long id){
        String url = "http://localhost:8085/app/movies/" + id;
        return restTemplate.getForObject(url, Movie.class);
    }

    public void returnMovie(Long id, boolean status){
        String url = "http://localhost:8085/app/movies/change/" + id;
        restTemplate.put(url, status);
    }

    public void rentMovie(Long id, boolean status) {
        String url = "http://localhost:8085/app/movies/change/" + id;

        restTemplate.put(url, status);
    }



}
