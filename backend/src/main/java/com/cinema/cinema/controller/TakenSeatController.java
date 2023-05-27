package com.cinema.cinema.controller;

import com.cinema.cinema.model.TakenSeat;
import com.cinema.cinema.service.TakenSeatService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    @PostMapping("/postTakenSeats")
    public Long addTakenSeats(@RequestBody String takenSeatsString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        TakenSeat[] seats = objectMapper.readValue(takenSeatsString, TakenSeat[].class);
        return takenSeatService.saveTakenSeats(Arrays.stream(seats).toList());
    }
}
