package com.example.kuby_api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.kuby_api.model.Orders;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long> {

    @Query("SELECT o.orders_id, o.orders_date, o.orders_status, o.orders_amount, o.id_localisation, " +
            "oi.order_items_id, oi.order_items_quantity, oi.unit_price, " +
            "ar.article_id, ar.article_name, ar.article_price " +
            "FROM Orders o " +
            "JOIN OrderItem oi ON o.orders_id = oi.id_order " +
            "JOIN Article ar ON oi.id_article = ar.article_id")
    List<Object[]> findAllOrdersWithDetails();

    @Query("SELECT o FROM Orders o JOIN Localisation l ON o.id_localisation = l.localisation_id WHERE l.id_user = :userId")
    List<Orders> findByUserId(@Param("userId") Integer userId);
}