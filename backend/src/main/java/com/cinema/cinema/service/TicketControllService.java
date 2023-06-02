package com.cinema.cinema.service;

import com.cinema.cinema.model.Order;
import com.cinema.cinema.model.TicketControl;
import com.cinema.cinema.repository.OrderRepository;
import com.cinema.cinema.repository.TakenSeatRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TicketControllService {
    private final TakenSeatRepository takenSeatRepository;
    private final OrderRepository orderRepository;

    public TicketControllService(TakenSeatRepository takenSeatRepository, OrderRepository orderRepository) {
        this.takenSeatRepository = takenSeatRepository;
        this.orderRepository = orderRepository;
    }

    public Optional<TicketControl> getTicketControlInfoByCode(String code){
        Optional<TicketControl> ticketControlOptional = this.orderRepository.findTicketControlByCode(code);
        if (ticketControlOptional.isPresent()) {
            TicketControl ticketControl = ticketControlOptional.get();
            if (!ticketControl.getStatus().equals("validated")){
                if (LocalDateTime.now().isAfter(ticketControl.getScreeningDateTime().minusMinutes(15)) & ticketControl.getScreeningDateTime().plusMinutes(ticketControl.getDuration()).isAfter(LocalDateTime.now())){
                    ticketControl.setStatus("active");
                }
            }
            System.out.println(ticketControl);
            return Optional.of(ticketControl);
        }
        return Optional.of(null);
    }
}
