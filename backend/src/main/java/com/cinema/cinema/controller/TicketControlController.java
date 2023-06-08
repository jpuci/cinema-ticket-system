package com.cinema.cinema.controller;

import com.cinema.cinema.model.TicketControl;
import com.cinema.cinema.service.TicketControllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class TicketControlController {

    @Autowired
    private TicketControllService ticketControllService;

    @GetMapping("/getTicketControlInfoByCode/{code}")
    public ResponseEntity<Object> getTicketControlInfoByCode(@PathVariable String code) {
        Optional<TicketControl> ticketControlOptional = ticketControllService.getTicketControlInfoByCode(code);
        return ticketControlOptional.isPresent()
                ? new ResponseEntity<>(ticketControlOptional.get(), HttpStatus.OK)
                : new ResponseEntity<>("Ticket control info not found", HttpStatus.NOT_FOUND);
    }
}
