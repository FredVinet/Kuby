package com.example.kuby_api.service;

import com.example.kuby_api.model.Order;
import com.example.kuby_api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import java.util.Optional;

@Data
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Optional<Order> getOrder(final Long id){
        return orderRepository.findById(id);
    }

    public Iterable<Order> getOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(final Long id){
        orderRepository.deleteById(id);
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
}
