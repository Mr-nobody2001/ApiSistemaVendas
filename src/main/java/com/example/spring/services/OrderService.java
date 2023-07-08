package com.example.spring.services;

import com.example.spring.model.entities.Order;
import com.example.spring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order findOrderById(long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);

        if (optionalOrder.isEmpty()) {
            return null;
        }

        return optionalOrder.get();
    }
}
