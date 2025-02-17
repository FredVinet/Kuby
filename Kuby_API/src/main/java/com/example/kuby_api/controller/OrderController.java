package com.example.kuby_api.controller;

import com.example.kuby_api.model.Orders;
import com.example.kuby_api.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/getAllOrders")
    public Iterable<Orders> getOrders() {
        return ordersService.getOrders();
    }

    @GetMapping("/getAllOrdersDetails")
    public List<Map<String, Object>> getAllOrdersWithDetails() {
        return ordersService.getAllOrdersWithDetails();
    }

    @GetMapping("/getOneOrder/{id}")
    public Optional<Orders> getOrdersById(@PathVariable Long id) {
        return ordersService.getOrders(id);
    }

    @PostMapping("/createOrder")
    public Orders createOrder(@RequestBody Orders orders) {
        return ordersService.createOrder(orders);
    }

    @PutMapping("/updateOrder/{id}")
    public Orders updateOrders(@PathVariable Long id, @RequestBody Orders orders) {
        orders.setOrders_id(id);
        return ordersService.createOrder(orders);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public void deleteOrders(@PathVariable Long id) {
        ordersService.deleteOrders(id);
    }
}