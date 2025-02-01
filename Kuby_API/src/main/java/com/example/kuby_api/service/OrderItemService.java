package com.example.kuby_api.service;

import com.example.kuby_api.model.OrderItem;
import com.example.kuby_api.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import java.util.Optional;

@Data
@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public Optional<OrderItem> getOrderItem(final Long id){
        return orderItemRepository.findById(id);
    }

    public Iterable<OrderItem> getOrderItems() {
        return orderItemRepository.findAll();
    }

    public void deleteOrderItem(final Long id){
        orderItemRepository.deleteById(id);
    }

    public OrderItem saveOrderItem(OrderItem orderItem){
        return orderItemRepository.save(orderItem);
    }
}
