package com.example.kuby_api.controller;

import com.example.kuby_api.model.Order;
import com.example.kuby_api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public Iterable<Order> getOrders() {
        return orderService.getOrders();
    }
}
