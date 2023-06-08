package com.cinema.cinema.service;

import com.cinema.cinema.model.Order;
import com.cinema.cinema.model.TicketControl;
import com.cinema.cinema.model.TicketControlType;
import com.cinema.cinema.repository.OrderRepository;
import com.cinema.cinema.repository.TakenSeatRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TicketControllService {
    private final OrderRepository orderRepository;

    public TicketControllService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<TicketControl> getTicketControlInfoByCode(String code) {
        Optional<TicketControlType> ticketControlOptional = this.orderRepository.findTicketControlByCode(code);
        if (ticketControlOptional.isPresent()) {
            TicketControlType ticketControlType = ticketControlOptional.get();
            TicketControl ticketControl = new TicketControl(ticketControlType.getCode(), ticketControlType.getStatus(),
                    ticketControlType.getSeats(), ticketControlType.getTicketsNumber(),
                    ticketControlType.getHallNumber(), ticketControlType.getScreeningDateTime(),
                    ticketControlType.getDuration());
            return Optional.of(ticketControl);
        }
        return Optional.of(null);
    }
}
