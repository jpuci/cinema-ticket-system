package com.cinema.cinema.controller;

import com.cinema.cinema.model.Code;
import com.cinema.cinema.model.Order;
import com.cinema.cinema.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getCodeByOrderId/{id}")
    public ResponseEntity<Object> getCodeByOrderId(@PathVariable String id) {
        Optional<Code> codeOptional = orderService.getCodeByOrderId(id);
        return codeOptional.isPresent()
                ? new ResponseEntity<>(codeOptional.get(), HttpStatus.OK)
                : new ResponseEntity<>("Code not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getOrderByCode/{code}")
    public ResponseEntity<Object> getOrderByCode(@PathVariable String code) {
        Optional<Order> orderOptional = orderService.getOrderByCode(code);
        return orderOptional.isPresent()
                ? new ResponseEntity<>(orderOptional.get(), HttpStatus.OK)
                : new ResponseEntity<>("Code not found", HttpStatus.NOT_FOUND);
    }
}
