package com.example.RentalService.Controller;

import com.example.RentalService.Model.Movie;
import com.example.RentalService.Service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.EscapeBodyTag;

import java.util.Optional;

@RestController
@RequestMapping("/app")
public class RentalController {

    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService){
        this.rentalService = rentalService;
    }

    @GetMapping("/rental/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id){
        Movie movie = rentalService.getMovie(id);
            return ResponseEntity.ok(movie);

    }

        @PutMapping("/rental/{id}/return")
        public ResponseEntity<Movie> returnMovie(@PathVariable Long id) {
            rentalService.returnMovie(id, true);
            return ResponseEntity.ok().build();
        }

    @PutMapping("/rental/{id}/rent")
    public ResponseEntity<Movie> rentMovie(@PathVariable Long id) {
        rentalService.rentMovie(id, false);
        return ResponseEntity.ok().build();
    }

}
