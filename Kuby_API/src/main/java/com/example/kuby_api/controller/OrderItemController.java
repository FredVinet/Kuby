package com.example.kuby_api.controller;

import com.example.kuby_api.model.OrderItem;
import com.example.kuby_api.model.OrderItem;
import com.example.kuby_api.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orderItems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/getAllOrderItems")
    public Iterable<OrderItem> getOrderItems() {
        return orderItemService.getOrderItems();
    }

    @GetMapping("/getOrderItemById/{id}")
    public Optional<OrderItem> getOrderItemById(@PathVariable Long id) {
        return orderItemService.getOrderItem(id);
    }

    @PostMapping("/createOrderItems")
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.createOrderItem(orderItem);
    }

    @PutMapping("/updateOrderItem/{id}")
    public OrderItem updateOrderItem(@PathVariable Long id, @RequestBody OrderItem orderItem) {
        orderItem.setOrder_items_id(id);
        return orderItemService.createOrderItem(orderItem);
    }

    @DeleteMapping("/deleteOrderItem/{id}")
    public void deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
    }
}