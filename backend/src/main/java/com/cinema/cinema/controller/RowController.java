package com.cinema.cinema.controller;

import com.cinema.cinema.service.RowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.cinema.cinema.model.Row;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class RowController {

    @Autowired
    private RowService rowService;

    @SuppressWarnings("OptionalIsPresent")
    @GetMapping("/getRowsByHallId/{id}")
    public ResponseEntity<Object> getRowsByHallId(@PathVariable String id) {
        Optional<List<Row>> rowsOptional = rowService.getRowsByHallId(id);
        return rowsOptional.isPresent()
                ? new ResponseEntity<>(rowsOptional.get(), HttpStatus.OK)
                : new ResponseEntity<>("Rows not found", HttpStatus.NOT_FOUND);
    }

}
