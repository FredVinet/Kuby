package com.example.kuby_api.controller;

import com.example.kuby_api.model.Orders;
import com.example.kuby_api.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping
    public Iterable<Orders> getOrders() {
        return ordersService.getOrders();
    }

    @GetMapping("/{id}")
    public Optional<Orders> getOrdersById(@PathVariable Long id) {
        return ordersService.getOrders(id);
    }

    @PostMapping
    public Orders createOrders(@RequestBody Orders orders) {
        return ordersService.saveOrders(orders);
    }

    @PutMapping("/{id}")
    public Orders updateOrders(@PathVariable Long id, @RequestBody Orders orders) {
        orders.setOrderId(id);
        return ordersService.saveOrders(orders);
    }

    @DeleteMapping("/{id}")
    public void deleteOrders(@PathVariable Long id) {
        ordersService.deleteOrders(id);
    }
}