package com.cinema.cinema.repository;

import com.cinema.cinema.model.Row;
import com.cinema.cinema.model.TakenSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TakenSeatRepository extends JpaRepository<TakenSeat, Long> {
    Optional<List<TakenSeat>> findAllByRepertoireId(Long idLong);
}