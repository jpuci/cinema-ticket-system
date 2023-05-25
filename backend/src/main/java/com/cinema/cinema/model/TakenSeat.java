package com.cinema.cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

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

    public TakenSeat(Long id, Long repertoireId, String rowName, Integer numberOfSeats) {
        this.id = id;
        this.repertoireId = repertoireId;
        this.rowName = rowName;
        this.seatNumber = numberOfSeats;
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
}
