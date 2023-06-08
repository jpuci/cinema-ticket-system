package com.cinema.cinema.model;

import java.time.LocalDateTime;

public interface TicketControlType {
    String getCode();
    String getStatus();
    String getSeats();
    Integer getTicketsNumber();
    Integer getHallNumber();
    LocalDateTime getScreeningDateTime();
    Integer getDuration();
}
