package com.cinema.cinema;

import com.cinema.cinema.model.Order;
import com.cinema.cinema.model.TakenSeat;
import com.cinema.cinema.repository.OrderRepository;
import com.cinema.cinema.repository.TakenSeatRepository;
import com.cinema.cinema.service.TakenSeatService;
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
import java.util.UUID;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TakenSeatServiceTest {

    @Mock
    private TakenSeatRepository takenSeatRepository;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private TakenSeatService takenSeatService;

    @Test
    public void Should_ReturnTakenSeats_WhenValidId() {
        // Given
        long repertoireId = 1L;
        TakenSeat seat1 = new TakenSeat(1L, repertoireId, "A", 1, null);
        TakenSeat seat2 = new TakenSeat(2L, repertoireId, "B", 2, null);
        List<TakenSeat> takenSeats = Arrays.asList(seat1, seat2);
        Mockito.when(takenSeatRepository.findAllByRepertoireId(repertoireId)).thenReturn(Optional.of(takenSeats));

        // When
        Optional<List<TakenSeat>> result = takenSeatService.getTakenSeatsByRepertoireId(String.valueOf(repertoireId));

        // Then
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(takenSeats, result.get());
    }

    @Test
    public void Should_ReturnOrderId() {
        // Given
        List<TakenSeat> takenSeats = Arrays.asList(
                new TakenSeat(1L, 1L, "A", 1, null),
                new TakenSeat(2L, 1L, "B", 2, null)
        );
        UUID uuid = UUID.randomUUID();
        String code = uuid.toString().replaceAll("[_-]", "").substring(0, 10);
        Order order = new Order(null, takenSeats.get(0).getRepertoireId(), code);
        Order savedOrder = new Order(1L, order.getRepertoireId(), order.getCode());
        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(savedOrder);
        Mockito.when(takenSeatRepository.saveAll(Mockito.anyList())).thenReturn(takenSeats);

        // When
        Long orderId = takenSeatService.saveTakenSeats(takenSeats);

        // Then
        Assertions.assertEquals(savedOrder.getId(), orderId);
        Mockito.verify(orderRepository).save(Mockito.any(Order.class));
        Mockito.verify(takenSeatRepository).saveAll(Mockito.anyList());
    }

}

