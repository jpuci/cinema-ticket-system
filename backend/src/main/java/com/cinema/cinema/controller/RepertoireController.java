package com.cinema.cinema.controller;

import com.cinema.cinema.model.Repertoire;
import com.cinema.cinema.service.RepertoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RepertoireController {
    @Autowired
    private RepertoireService repertoireService;

    @SuppressWarnings("OptionalIsPresent")
    @GetMapping("/getRepertoireByMovieId/{id}")
    public ResponseEntity<Object> getRepertoireByMovieId(@PathVariable String id) {
        Optional<List<Repertoire>> repertoireOptional = repertoireService.getRepertoireByMovieId(id);
        return repertoireOptional.isPresent()
                ? new ResponseEntity<>(repertoireOptional.get(), HttpStatus.OK)
                : new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getSeancesTodayByMovieId/{id}")
    public ResponseEntity<Object> getSeancesTodayByMovieId(@PathVariable String id) {
        List<Repertoire> repertoire = repertoireService.getSeancesTodayByMovieId(id);
        return !repertoire.isEmpty()
                ? new ResponseEntity<>(repertoire, HttpStatus.OK)
                : new ResponseEntity<>("Seances not found", HttpStatus.NOT_FOUND);
    }
}
