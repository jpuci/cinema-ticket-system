package com.cinema.cinema.controller;

import com.cinema.cinema.model.Movie;
import com.cinema.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/getMovies")
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
    }

    @SuppressWarnings("OptionalIsPresent")
    @GetMapping("/getMovieById/{id}")
    public ResponseEntity<Object> getOrderHistoryById(@PathVariable String id) {
        Optional<Movie> movieOptional = movieService.getMovieById(id);
        return movieOptional.isPresent()
                ? new ResponseEntity<>(movieOptional.get(), HttpStatus.OK)
                : new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
    }
}