package com.example.kuby_api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.kuby_api.model.Orders;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long> {
    @Query("SELECT o FROM Orders o JOIN Localisation l ON o.id_localisation = l.localisation_id WHERE l.id_user = :userId")
    List<Orders> findByUserId(@Param("userId") Integer userId);
}