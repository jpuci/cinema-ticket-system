package com.cinema.cinema;

import com.cinema.cinema.model.Repertoire;
import com.cinema.cinema.repository.RepertoireRepository;
import com.cinema.cinema.service.RepertoireService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RepertoireServiceTest {

    @Mock
    private RepertoireRepository repertoireRepository;

    @InjectMocks
    private RepertoireService repertoireService;

    @Test
    public void Should_ReturnRepertoireToday_WhenMovieIdIsCorrect() {
        // given
        List<Repertoire> repertoire = new ArrayList<>();
        long movieId = 1L;
        LocalDateTime screeningDateTime = LocalDateTime.now();
        repertoire.add(new Repertoire(1L, movieId, screeningDateTime, 1L));
        repertoire.add(new Repertoire(2L, movieId, screeningDateTime.plusHours(2),2L));

        // when
        when(repertoireRepository.findAllByMovieId(movieId)).thenReturn(Optional.of(repertoire));
        List<Repertoire> result = repertoireService.getRepertoireTodayByMovieId(String.valueOf(movieId));

        // then
        assertEquals(2, result.size());
        assertEquals(repertoire.get(0), result.get(0));
    }

    @Test
    public void Should_ReturnRepertoireToday() {
        // given
        List<Repertoire> repertoire = new ArrayList<>();
        LocalDateTime screeningDateTime = LocalDateTime.now();
        repertoire.add(new Repertoire(1L, 1L, screeningDateTime, 1L));
        repertoire.add(new Repertoire(2L, 2L, screeningDateTime.plusHours(2), 2L));

        // when
        when(repertoireRepository.findAll()).thenReturn(repertoire);
        List<Repertoire> result = repertoireService.getRepertoireToday();

        // then
        assertEquals(repertoire, result);
    }

    @Test
    public void Should_ReturnRepertoire_WhenMovieIdIsCorrect() {
        // given
        List<Repertoire> repertoire = new ArrayList<>();
        long movieId = 1L;
        repertoire.add(new Repertoire(1L, movieId, LocalDateTime.now(), 1L));
        repertoire.add(new Repertoire(2L, movieId, LocalDateTime.now().plusHours(2), 2L));

        // when
        when(repertoireRepository.findAllByMovieId(movieId)).thenReturn(Optional.of(repertoire));
        Optional<List<Repertoire>> result = repertoireService.getRepertoireByMovieId(String.valueOf(movieId));

        // then
        assertEquals(Optional.of(repertoire), result);
    }

    @Test
    public void Should_ReturnRepertoire_WhenRepertoireIdIsCorrect() {
        // given
        long id = 1L;
        Repertoire repertoire = new Repertoire(id, 1L, LocalDateTime.now(), 1L);

        // when
        when(repertoireRepository.findById(id)).thenReturn(Optional.of(repertoire));
        Optional<Repertoire> result = repertoireService.getRepertoireById(String.valueOf(id));

        // then
        assertEquals(Optional.of(repertoire), result);
    }

    @Test(expected = NumberFormatException.class)
    public void Should_ThrowNumberFormatException_WhenRepertoireIdIsInvalid() {
        repertoireService.getRepertoireById("invalid");
    }
}
