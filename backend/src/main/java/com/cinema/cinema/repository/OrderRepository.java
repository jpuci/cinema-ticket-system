package com.cinema.cinema.repository;

import com.cinema.cinema.model.Order;
import com.cinema.cinema.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Code> findCodeById(Long id);
    Optional<Code> findOrderByCode(String code);
}
