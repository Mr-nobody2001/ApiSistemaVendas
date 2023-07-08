package com.example.spring.resources;

import com.example.spring.model.entities.Order;
import com.example.spring.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Order>> findAllOrders() {
        List<Order> orderList = orderService.findAllOrders();

        return ResponseEntity.ok().body(orderList);
    }
    @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> findOrderById(@PathVariable(value = "orderId") long orderId) {
        Order order = orderService.findOrderById(orderId);

        return ResponseEntity.ok().body(order);
    }
}
