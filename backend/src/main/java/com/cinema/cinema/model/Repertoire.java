package com.cinema.cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "REPERTOIRE")
public class Repertoire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("movie_id")
    private Long movieId;
    @JsonProperty("date")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime seanceDateTime;

    public Repertoire(Long id, Long movieId, LocalDateTime seanceDateTime) {
        this.id = id;
        this.movieId = movieId;
        this.seanceDateTime = seanceDateTime;
    }

    public Repertoire() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public LocalDateTime getSeanceDateTime() {
        return seanceDateTime;
    }

    public void setSeanceDateTime(LocalDateTime seanceDateTime) {
        this.seanceDateTime = seanceDateTime;
    }

    public LocalDate getSeanceDate() {
        return this.seanceDateTime.toLocalDate();
    }
}