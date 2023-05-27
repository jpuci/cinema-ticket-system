package com.cinema.cinema.service;

import com.cinema.cinema.model.Order;
import com.cinema.cinema.model.TakenSeat;
import com.cinema.cinema.repository.OrderRepository;
import com.cinema.cinema.repository.TakenSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TakenSeatService {

    private final TakenSeatRepository takenSeatRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public TakenSeatService(TakenSeatRepository takenSeatRepository, OrderRepository orderRepository) {
        this.takenSeatRepository = takenSeatRepository;
        this.orderRepository = orderRepository;
    }

    public Optional<List<TakenSeat>> getTakenSeatsByRepertoireId(String id) throws NumberFormatException {
        long idLong = Long.parseLong(id);
        return takenSeatRepository.findAllByRepertoireId(idLong);
    }

    public Long saveTakenSeats(List<TakenSeat> takenSeats) {
        UUID randomUUID = UUID.randomUUID();
        String code = randomUUID.toString().replaceAll("[_-]", "").substring(0, 10);
        Order order = new Order(null, takenSeats.get(0).getRepertoireId(), code);
        Order newOrder = orderRepository.save(order);
        Long id = newOrder.getId();
        for (TakenSeat seat : takenSeats) {
            seat.setOrderId(id);
        }
        takenSeatRepository.saveAll(takenSeats);
        return id;
    }
}
