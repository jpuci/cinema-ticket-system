package com.cinema.cinema.controller;

import com.cinema.cinema.model.Repertoire;
import com.cinema.cinema.service.RepertoireService;
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

    @GetMapping("/getRepertoireTodayByMovieId/{id}")
    public ResponseEntity<Object> getRepertoireTodayByMovieId(@PathVariable String id) {
        List<Repertoire> repertoire = repertoireService.getRepertoireTodayByMovieId(id);
        return !repertoire.isEmpty()
                ? new ResponseEntity<>(repertoire, HttpStatus.OK)
                : new ResponseEntity<>("Screenings not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getRepertoireToday")
    public ResponseEntity<Object> getRepertoireToday() {
        Optional<List<Repertoire>> repertoire = repertoireService.getRepertoireToday();
        return repertoire.isPresent()
                ? new ResponseEntity<>(repertoire, HttpStatus.OK)
                : new ResponseEntity<>("Screenings not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getRepertoireById/{id}")
    public ResponseEntity<Object> getRepertoireById(@PathVariable String id) {
        System.out.println(id);
        Optional<Repertoire> repertoire = repertoireService.getRepertoireById(id);
        return repertoire.isPresent()
                ? new ResponseEntity<>(repertoire, HttpStatus.OK)
                : new ResponseEntity<>("Screenings not found", HttpStatus.NOT_FOUND);
    }

}
