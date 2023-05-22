package com.cinema.cinema.service;

import com.cinema.cinema.model.Movie;
import com.cinema.cinema.model.Repertoire;
import com.cinema.cinema.model.Row;
import com.cinema.cinema.model.TakenSeat;
import com.cinema.cinema.repository.RowRepository;
import com.cinema.cinema.repository.MovieRepository;
import com.cinema.cinema.repository.RepertoireRepository;
import com.cinema.cinema.repository.TakenSeatRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void loadJsonData() {
        loadMoviesData();
        loadRepertoireData();
        loadRowsData();
        loadTakenSeatsData();
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
}
