package com.cinema.cinema.model;

import java.time.LocalDateTime;

public class TicketControl {

    String code;
    String status;
    String seats;
    Integer ticketsNumber;
    Integer hallNumber;
    LocalDateTime screeningDateTime;
    Integer duration;
    Long orderId;

    public TicketControl() {

    }

    public TicketControl(String code, String status, String seats, Integer ticketsNumber, Integer hallNumber,
                         LocalDateTime screeningDateTime, Integer duration, Long orderId) {
        this.code = code;
        this.status = status;
        this.seats = seats;
        this.ticketsNumber = ticketsNumber;
        this.hallNumber = hallNumber;
        this.screeningDateTime = screeningDateTime;
        this.duration = duration;
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public Integer getTicketsNumber() {
        return ticketsNumber;
    }

    public void setTicketsNumber(Integer ticketsNumber) {
        this.ticketsNumber = ticketsNumber;
    }

    public Integer getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(Integer hallNumber) {
        this.hallNumber = hallNumber;
    }

    public LocalDateTime getScreeningDateTime() {
        return screeningDateTime;
    }

    public void setScreeningDateTime(LocalDateTime screeningDateTime) {
        this.screeningDateTime = screeningDateTime;
    }
}
