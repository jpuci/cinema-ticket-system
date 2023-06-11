package com.cinema.cinema.repository;

import com.cinema.cinema.model.Order;
import com.cinema.cinema.model.Code;
import com.cinema.cinema.model.TicketControlType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Code> findCodeById(Long id);

    Optional<Order> findOrderByCode(String code);

    @Query(value = "SELECT TOP(1) o.code as code, o.status as status,  " +
            "GROUP_CONCAT(concat(t.row_Name, t.seat_Number)) as seats, COUNT(t.id) as ticketsNumber,  r.hall_Id as hallNumber, r.screening_Date_Time as screeningDateTime, m.duration as duration, o.id as orderId " +
            " FROM ORDERS_TABLE o LEFT JOIN Repertoire r ON o.repertoire_Id = r.id " +
            "                      LEFT JOIN Movies m ON r.movie_Id = m.id " +
            "LEFT JOIN TAKEN_SEATS t ON t.order_Id = o.id " +
            "WHERE o.code = ?1 GROUP BY o.code, o.status, r.screening_Date_Time, r.hall_Id, m.duration",
            nativeQuery = true)
    Optional<TicketControlType> findTicketControlByCode(String code);
}
