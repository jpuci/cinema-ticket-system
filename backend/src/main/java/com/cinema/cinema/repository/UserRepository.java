package com.cinema.cinema.repository;

import com.cinema.cinema.model.TakenSeat;
import com.cinema.cinema.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
    Optional<User> findByUsername(String username);
}