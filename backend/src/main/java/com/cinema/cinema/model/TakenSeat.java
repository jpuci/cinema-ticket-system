package com.cinema.cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "TAKEN_SEATS")
public class TakenSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("repertoire_id")
    private Long repertoireId;
    @JsonProperty("row_name")
    private String rowName;
    @JsonProperty("seat_number")
    private Integer seatNumber;
    @JsonProperty("order_id")
    private Long orderId;

    public TakenSeat(Long id, Long repertoireId, String rowName, Integer numberOfSeats, Long orderId) {
        this.id = id;
        this.repertoireId = repertoireId;
        this.rowName = rowName;
        this.seatNumber = numberOfSeats;
        this.orderId = orderId;
    }

    public TakenSeat() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRepertoireId() {
        return repertoireId;
    }

    public void setRepertoireId(Long repertoireId) {
        this.repertoireId = repertoireId;
    }

    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
