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

    @Query(value = "SELECT o.code, o.status, COUNT(t.id),  r.hall_Id,  " +
            "array_to_string(array_agg(concat(t.row_Name, t.seat_Number))), r.screening_Date_Time, m.duration " +
            " FROM ORDERS_TABLE o LEFT JOIN Repertoire r ON o.repertoire_Id = r.id " +
            "                      LEFT JOIN Movies m ON r.movie_Id = m.id " +
            "LEFT JOIN TAKEN_SEATS t ON t.order_Id = o.id " +
            "WHERE o.code = ?1 GROUP BY o.code, o.status, r.screening_Date_Time, r.hall_Id, m.duration",
            nativeQuery = true)
    Optional<TicketControl> findTicketControlByCode(String code);
}
