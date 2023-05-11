package com.cinema.cinema.service;

import com.cinema.cinema.model.Movie;
import com.cinema.cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(String id) throws NumberFormatException {
        long idLong = Long.parseLong(id);
        return movieRepository.findById(idLong);
    }
}