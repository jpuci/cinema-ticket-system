package com.cinema.cinema.service;

import com.cinema.cinema.model.Halls;
import com.cinema.cinema.model.Movie;
import com.cinema.cinema.model.Repertoire;
import com.cinema.cinema.repository.HallsRepository;
import com.cinema.cinema.repository.MovieRepository;
import com.cinema.cinema.repository.RepertoireRepository;
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
    private HallsRepository hallsRepository;

    public void loadJsonData() {
        loadMoviesData();
        loadRepertoireData();
        loadHallsData();
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

    private void loadHallsData() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON file
            InputStream inputStream = getClass().getResourceAsStream("/json/halls.json");

            // Parse the JSON data into an array of Repertoire objects
            Halls[] halls = objectMapper.readValue(inputStream, Halls[].class);

            // Save all Halls objects to the H2 database
            hallsRepository.saveAll(Arrays.asList(halls));

            System.out.println("Halls loaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
