package com.cinema.cinema;

import com.cinema.cinema.model.Movie;
import com.cinema.cinema.repository.MovieRepository;
import com.cinema.cinema.service.MovieService;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMovies() {
        // Create a list of movies
        List<Movie> movies = Arrays.asList(new Movie(1L, "Movie 1", 120, "Director 1", "image1.jpg", "Short description 1", "Description 1"), new Movie(2L, "Movie 2", 90, "Director 2", "image2.jpg", "Short description 2", "Description 2"));

        // Mock the movieRepository.findAll method
        when(movieRepository.findAll()).thenReturn(movies);

        // Call the method to be tested
        List<Movie> result = movieService.getMovies();

        // Verify the result
        assertEquals(movies, result);
    }

    @Test
    public void testGetMovieById() {
        // Create a movie with the given ID
        long id = 1L;
        Movie movie = new Movie(id, "Movie 1", 120, "Director 1", "image1.jpg", "Short description 1", "Description 1");

        // Mock the movieRepository.findById method
        when(movieRepository.findById(id)).thenReturn(Optional.of(movie));

        // Call the method to be tested
        Optional<Movie> result = movieService.getMovieById(String.valueOf(id));

        // Verify the result
        assertEquals(Optional.of(movie), result);
    }

    @Test(expected = NumberFormatException.class)
    public void testGetMovieById_InvalidId() {
        // Call the method with an invalid ID
        movieService.getMovieById("invalid");
    }
}

