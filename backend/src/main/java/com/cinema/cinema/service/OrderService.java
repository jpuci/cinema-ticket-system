package com.cinema.cinema.service;

import com.cinema.cinema.model.Code;
import com.cinema.cinema.model.Order;
import com.cinema.cinema.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Code> getCodeByOrderId(String id) throws NumberFormatException {
        long idLong = Long.parseLong(id);
        return orderRepository.findCodeById(idLong);
    }

    public Optional<Order> getOrderByCode(String code) {
        return orderRepository.findOrderByCode(code);
    }

    public void updateOrderStatus(long id, String status) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            order.setStatus(status);
            orderRepository.save(order);
        }
    }
}
