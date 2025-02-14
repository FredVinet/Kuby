package com.example.kuby_api.service;

import com.example.kuby_api.model.OrderItem;
import com.example.kuby_api.repository.OrderItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import java.util.Optional;

@Data
@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ArticleService articleService;

    public Optional<OrderItem> getOrderItem(final Long id){
        return orderItemRepository.findById(id);
    }

    public Iterable<OrderItem> getOrderItems() {
        return orderItemRepository.findAll();
    }

    public void deleteOrderItem(final Long id){
        orderItemRepository.deleteById(id);
    }

    @Transactional
    public OrderItem createOrderItem(OrderItem orderItem) {
        // Vérifier et mettre à jour le stock
        articleService.decreaseArticleQuantity(orderItem.getId_article(), orderItem.getOrder_items_quantity());

        return orderItemRepository.save(orderItem);
    }
}