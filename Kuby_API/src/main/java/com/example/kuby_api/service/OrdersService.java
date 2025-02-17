package com.example.kuby_api.service;

import com.example.kuby_api.model.Orders;
import com.example.kuby_api.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

import java.util.*;

@Data
@Service
public class OrdersService {

    @Autowired
    private OrdersRepository orderRepository;

    public List<Map<String, Object>> getAllOrdersWithDetails() {
        List<Object[]> results = orderRepository.findAllOrdersWithDetails();
        List<Map<String, Object>> ordersWithDetails = new ArrayList<>();

        // Pour chaque résultat de la requête, on transforme les données en un Map
        for (Object[] row : results) {
            Map<String, Object> orderData = new HashMap<>();
            orderData.put("orders_id", row[0]);
            orderData.put("orders_date", row[1]);
            orderData.put("orders_status", row[2]);
            orderData.put("orders_amount", row[3]);
            orderData.put("id_localisation", row[4]);
            orderData.put("id_user", row[5]);
            orderData.put("id_adress", row[6]);  
            orderData.put("adress_number", row[7]);
            orderData.put("adress_country", row[8]);
            orderData.put("adress_state", row[9]);
            orderData.put("adress_name", row[10]);
            orderData.put("adress_city", row[11]);
            orderData.put("adress_code", row[12]);
            orderData.put("user_id", row[13]);  // ✅ Correspond maintenant à la requête SQL
            orderData.put("user_name", row[14]);
            orderData.put("user_firstname", row[15]);
            orderData.put("userType", row[16]);  // ✅ Correspond maintenant à la requête SQL

            ordersWithDetails.add(orderData);
        }

        return ordersWithDetails;
    }


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