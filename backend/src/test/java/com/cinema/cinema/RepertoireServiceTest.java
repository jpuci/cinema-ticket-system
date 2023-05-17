package com.cinema.cinema;

import com.cinema.cinema.model.Repertoire;
import com.cinema.cinema.repository.RepertoireRepository;
import com.cinema.cinema.service.RepertoireService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RepertoireServiceTest {

    @Mock
    private RepertoireRepository repertoireRepository;

    @InjectMocks
    private RepertoireService repertoireService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetRepertoireTodayByMovieId() {
        // Create a list of repertoire
        List<Repertoire> repertoire = new ArrayList<>();
        long movieId = 1L;
        LocalDateTime screeningDateTime = LocalDateTime.now();
        repertoire.add(new Repertoire(1L, movieId, screeningDateTime, 1L));
        repertoire.add(new Repertoire(2L, movieId, screeningDateTime.plusHours(2),2L));

        // Mock the repertoireRepository.findAllByMovieId method
        when(repertoireRepository.findAllByMovieId(movieId)).thenReturn(Optional.of(repertoire));

        // Call the method to be tested
        List<Repertoire> result = repertoireService.getRepertoireTodayByMovieId(String.valueOf(movieId));
        System.out.println(result);

        // Verify the result
        assertEquals(2, result.size());
        assertEquals(repertoire.get(0), result.get(0));
    }

    @Test
    public void testGetRepertoireToday() {
        // Create a list of repertoire
        List<Repertoire> repertoire = new ArrayList<>();
        LocalDateTime screeningDateTime = LocalDateTime.now();
        repertoire.add(new Repertoire(1L, 1L, screeningDateTime, 1L));
        repertoire.add(new Repertoire(2L, 2L, screeningDateTime.plusHours(2), 2L));

        // Mock the repertoireRepository.findAll method
        when(repertoireRepository.findAll()).thenReturn(repertoire);

        // Call the method to be tested
        List<Repertoire> result = repertoireService.getRepertoireToday();

        // Verify the result
        assertEquals(repertoire, result);
    }

    @Test
    public void testGetRepertoireByMovieId() {
        // Create a list of repertoire
        List<Repertoire> repertoire = new ArrayList<>();
        long movieId = 1L;
        repertoire.add(new Repertoire(1L, movieId, LocalDateTime.now(), 1L));
        repertoire.add(new Repertoire(2L, movieId, LocalDateTime.now().plusHours(2), 2L));

        // Mock the repertoireRepository.findAllByMovieId method
        when(repertoireRepository.findAllByMovieId(movieId)).thenReturn(Optional.of(repertoire));

        // Call the method to be tested
        Optional<List<Repertoire>> result = repertoireService.getRepertoireByMovieId(String.valueOf(movieId));

        // Verify the result
        assertEquals(Optional.of(repertoire), result);
    }

    @Test
    public void testGetRepertoireById() {
        // Create a repertoire with the given ID
        long id = 1L;
        Repertoire repertoire = new Repertoire(id, 1L, LocalDateTime.now(), 1L);

        // Mock the repertoireRepository.findById method
        when(repertoireRepository.findById(id)).thenReturn(Optional.of(repertoire));

        // Call the method to be tested
        Optional<Repertoire> result = repertoireService.getRepertoireById(String.valueOf(id));

        // Verify the result
        assertEquals(Optional.of(repertoire), result);
    }

    @Test(expected = NumberFormatException.class)
    public void testGetRepertoireById_InvalidId() {
        // Call the method with an invalid ID
        repertoireService.getRepertoireById("invalid");
    }
}

