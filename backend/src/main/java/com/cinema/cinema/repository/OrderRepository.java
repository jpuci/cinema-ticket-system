package com.cinema.cinema.repository;

import com.cinema.cinema.model.Order;
import com.cinema.cinema.model.Code;
import com.cinema.cinema.model.TicketControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Code> findCodeById(Long id);
    Optional<Order> findOrderByCode(String code);

    @Query(value="SELECT o.code,  o.status, COUNT(t.id),  r.hallId,  " +
            "array_to_string(array_agg(concat(t.rowName, t.seatNumber))), r.screeningDateTime, m.duration " +
            " FROM Order o LEFT JOIN Repertoire r ON o.repertoireId = r.id " +
            "                      LEFT JOIN Movie m ON r.movieId = m.id " +
            "LEFT JOIN TakenSeat t ON t.orderId = o.id " +
            "WHERE o.code = ?1 GROUP BY o.code, o.status, r.screeningDateTime, r.hallId, m.duration",
            nativeQuery = true)
    Optional<TicketControl> findTicketControlByCode(String code);
}
