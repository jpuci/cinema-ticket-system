package com.cinema.cinema.controller;

import com.cinema.cinema.model.TakenSeat;
import com.cinema.cinema.service.RowService;
import com.cinema.cinema.service.TakenSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cinema.cinema.model.Row;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class TakenSeatController {

    @Autowired
    private TakenSeatService takenSeatService;

    @SuppressWarnings("OptionalIsPresent")
    @GetMapping("/getTakenSeatsByRepertoireId/{id}")
    public ResponseEntity<Object> getTakenSeatsByRepertoireId(@PathVariable String id) {
        Optional<List<TakenSeat>> takenSeatsOptional = takenSeatService.getTakenSeatsByRepertoireId(id);
        return takenSeatsOptional.isPresent()
                ? new ResponseEntity<>(takenSeatsOptional.get(), HttpStatus.OK)
                : new ResponseEntity<>("Taken seats not found", HttpStatus.NOT_FOUND);
    }

//    @PostMapping("/postTakenSeats")
//    public TakenSeat addTakenSeats(@RequestBody TakenSeat[] takenSeats) {
//        return takenSeatService.saveTakenSeats(takenSeats);
//    }
}
