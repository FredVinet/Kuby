package com.example.kuby_api.service;

import com.example.kuby_api.model.Orders;
import com.example.kuby_api.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import java.util.Optional;

@Data
@Service
public class OrdersService {

    @Autowired
    private OrdersRepository orderRepository;

    public Optional<Orders> getOrders(final Long id){
        return orderRepository.findById(id);
    }

    public Iterable<Orders> getOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrders(final Long id){
        orderRepository.deleteById(id);
    }

    public Orders createOrder(Orders order){
        return orderRepository.save(order);
    }
}