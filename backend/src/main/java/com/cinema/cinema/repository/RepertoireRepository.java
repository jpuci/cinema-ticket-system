package com.cinema.cinema.repository;

import com.cinema.cinema.model.Repertoire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RepertoireRepository extends JpaRepository<Repertoire, Long> {
    Optional<List<Repertoire>> findAllByMovieId(Long id);
    Optional<List<Repertoire>> findAllByScreeningDateTimeAfter(LocalDateTime date);

}
