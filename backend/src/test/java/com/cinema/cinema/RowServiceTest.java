package com.cinema.cinema;

import com.cinema.cinema.model.Row;
import com.cinema.cinema.repository.RowRepository;
import com.cinema.cinema.service.RowService;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RowServiceTest {

    @Mock
    private RowRepository rowRepository;

    @InjectMocks
    private RowService rowService;

    @Test
    public void Should_dReturnRows_WhenValidId() {
        // Given
        long hallId = 1L;
        Row row1 = new Row(1L, hallId, "A", 10);
        Row row2 = new Row(2L, hallId, "B", 15);
        List<Row> rows = Arrays.asList(row1, row2);
        Mockito.when(rowRepository.findAllByHallIdOrderByRowName(hallId)).thenReturn(Optional.of(rows));

        // When
        Optional<List<Row>> result = rowService.getRowsByHallId(String.valueOf(hallId));

        // Then
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(rows, result.get());
    }
}

