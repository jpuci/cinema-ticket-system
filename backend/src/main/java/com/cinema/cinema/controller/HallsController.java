package com.cinema.cinema.controller;

import com.cinema.cinema.model.Halls;
import com.cinema.cinema.model.Movie;
import com.cinema.cinema.service.HallsService;
import com.cinema.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class HallsController {

    @Autowired
    private HallsService hallsService;

    @SuppressWarnings("OptionalIsPresent")
    @GetMapping("/getHallById/{id}")
    public ResponseEntity<Object> getOrderHistoryById(@PathVariable String id) {
        Optional<List<Halls>> hallsOptional = hallsService.getHallById(id);
        return hallsOptional.isPresent()
                ? new ResponseEntity<>(hallsOptional.get(), HttpStatus.OK)
                : new ResponseEntity<>("Hall not found", HttpStatus.NOT_FOUND);
    }

}
