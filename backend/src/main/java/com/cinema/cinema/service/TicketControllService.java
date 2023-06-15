package com.cinema.cinema.service;

import com.cinema.cinema.model.TicketControl;
import com.cinema.cinema.model.TicketControlType;
import com.cinema.cinema.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
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
            LocalDateTime currentDateTime = LocalDateTime.now();
            LocalDateTime screeningDateTime = ticketControlType.getScreeningDateTime();
            Integer duration = ticketControlType.getDuration();
            LocalDateTime movieEndDateTime = screeningDateTime.plusMinutes(duration);
            String currentStatus = ticketControlType.getStatus();

            if (currentDateTime.isAfter(screeningDateTime.minusMinutes(15L)) &&
                    currentDateTime.isBefore(movieEndDateTime) && !Objects.equals(ticketControlType.getStatus(), "checked"))
                currentStatus = "active";
            else if (currentDateTime.isAfter(movieEndDateTime)) currentStatus = "inactive";
            TicketControl ticketControl = new TicketControl(ticketControlType.getCode(), currentStatus,
                    ticketControlType.getSeats(), ticketControlType.getTicketsNumber(),
                    ticketControlType.getHallNumber(), ticketControlType.getScreeningDateTime(),
                    ticketControlType.getDuration(), ticketControlType.getOrderId());
            return Optional.of(ticketControl);
        }
        return Optional.of(null);
    }
}
