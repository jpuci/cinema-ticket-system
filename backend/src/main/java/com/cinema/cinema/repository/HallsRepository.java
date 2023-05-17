package com.cinema.cinema.repository;

import com.cinema.cinema.model.Halls;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HallsRepository extends JpaRepository<Halls, Long> {
    Optional<List<Halls>> findAllByHallIdOrderByRowName(Long idLong);
}