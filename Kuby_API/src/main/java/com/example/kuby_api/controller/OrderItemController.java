package com.example.kuby_api.controller;

import com.example.kuby_api.model.OrderItem;
import com.example.kuby_api.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/orderitems")
    public Iterable<OrderItem> getOrderItems() {
        return orderItemService.getOrderItems();
    }
}
