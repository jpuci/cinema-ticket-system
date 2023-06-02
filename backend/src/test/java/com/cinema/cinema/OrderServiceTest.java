package com.cinema.cinema;

import com.cinema.cinema.model.Code;
import com.cinema.cinema.repository.OrderRepository;
import com.cinema.cinema.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void Should_ReturnCode_GivenCorrectOrderId() {
        // Given
        long orderId = 1L;
        String codeValue = "ABC123";
        Code code = () -> codeValue;
        Mockito.when(orderRepository.findCodeById(orderId)).thenReturn(Optional.of(code));

        // When
        Optional<Code> result = orderService.getCodeByOrderId(String.valueOf(orderId));

        // Then
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(codeValue, result.get().getCode());
    }
}

