package com.cinema.cinema.service;

import com.cinema.cinema.model.*;
import com.cinema.cinema.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@Service
public class JsonLoaderService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RepertoireRepository repertoireRepository;

    @Autowired
    private RowRepository rowRepository;

    @Autowired
    private TakenSeatRepository takenSeatRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void loadJsonData() {
        loadMoviesData();
        loadRepertoireData();
        loadRowsData();
        loadTakenSeatsData();
        loadOrderData();
        loadUserData();
    }

    private void loadMoviesData() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON file
            InputStream inputStream = getClass().getResourceAsStream("/json/movies.json");

            // Parse the JSON data into an array of Movie objects
            Movie[] movies = objectMapper.readValue(inputStream, Movie[].class);

            // Save all Movie objects to the H2 database
            movieRepository.saveAll(Arrays.asList(movies));

            System.out.println("Movies loaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadRepertoireData() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON file
            InputStream inputStream = getClass().getResourceAsStream("/json/repertoire.json");

            // Parse the JSON data into an array of Repertoire objects
            Repertoire[] repertoire = objectMapper.readValue(inputStream, Repertoire[].class);

            // Save all Repertoire objects to the H2 database
            repertoireRepository.saveAll(Arrays.asList(repertoire));

            System.out.println("Repertoire loaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadRowsData() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON file
            InputStream inputStream = getClass().getResourceAsStream("/json/rows.json");

            // Parse the JSON data into an array of Repertoire objects
            Row[] halls = objectMapper.readValue(inputStream, Row[].class);

            // Save all Rows objects to the H2 database
            rowRepository.saveAll(Arrays.asList(halls));

            System.out.println("Rows loaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTakenSeatsData() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON file
            InputStream inputStream = getClass().getResourceAsStream("/json/taken_seats.json");

            // Parse the JSON data into an array of Repertoire objects
            TakenSeat[] seats = objectMapper.readValue(inputStream, TakenSeat[].class);

            // Save all Rows objects to the H2 database
            takenSeatRepository.saveAll(Arrays.asList(seats));

            System.out.println("Taken seats loaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadOrderData() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON file
            InputStream inputStream = getClass().getResourceAsStream("/json/orders.json");

            // Parse the JSON data into an array of Repertoire objects
            Order[] orders = objectMapper.readValue(inputStream, Order[].class);

            // Save all Repertoire objects to the H2 database
            orderRepository.saveAll(Arrays.asList(orders));

            System.out.println("Orders loaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadUserData() {
        ObjectMapper objectMapper = new ObjectMapper();

        String encodedPassword = passwordEncoder.encode("p1");

        // Create a new user and set the encoded password
        User user = new User();
        user.setUsername("Asia");
        user.setPassword(encodedPassword);
        // Set other user properties

        // Save the user to the UserRepository
        userRepository.save(user);

        System.out.println("Users loaded successfully!");
    }
}
