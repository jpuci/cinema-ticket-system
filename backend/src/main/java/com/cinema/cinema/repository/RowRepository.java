package com.cinema.cinema.repository;

import com.cinema.cinema.model.Row;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RowRepository extends JpaRepository<Row, Long> {
    Optional<List<Row>> findAllByHallIdOrderByRowName(Long idLong);
}