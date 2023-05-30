package com.cinema.cinema;

import com.cinema.cinema.model.Movie;
import com.cinema.cinema.repository.MovieRepository;
import com.cinema.cinema.service.MovieService;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @Test
    public void Should_ReturnMovies() {
        // given
        List<Movie> movies = Arrays.asList(new Movie(1L, "Movie 1", 120, "Director 1", "image1.jpg", "Short description 1", "Description 1"), new Movie(2L, "Movie 2", 90, "Director 2", "image2.jpg", "Short description 2", "Description 2"));

        // when
        when(movieRepository.findAll()).thenReturn(movies);
        List<Movie> result = movieService.getMovies();

        // then
        assertEquals(movies, result);
    }

    @Test
    public void Should_ReturnMovie_WhenMovieIdIsCorrect() {
        // given
        long id = 1L;
        Movie movie = new Movie(id, "Movie 1", 120, "Director 1", "image1.jpg", "Short description 1", "Description 1");

        // when
        when(movieRepository.findById(id)).thenReturn(Optional.of(movie));
        Optional<Movie> result = movieService.getMovieById(String.valueOf(id));

        // then
        assertEquals(Optional.of(movie), result);
    }

    @Test(expected = NumberFormatException.class)
    public void Should_ThrowNumberFormatException_WhenMovieIdIsInvalid() {
        movieService.getMovieById("invalid");
    }
}

