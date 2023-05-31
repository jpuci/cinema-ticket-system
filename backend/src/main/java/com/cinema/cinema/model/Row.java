package com.cinema.cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "CINEMA_ROWS")
public class Row {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("hall_id")
    private Long hallId;
    @JsonProperty("row_name")
    private String rowName;
    @JsonProperty("number_of_seats")
    private Integer numberOfSeats;

    public Row(Long id, Long hallId, String rowName, Integer numberOfSeats) {
        this.id = id;
        this.hallId = hallId;
        this.rowName = rowName;
        this.numberOfSeats = numberOfSeats;
    }

    public Row() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
