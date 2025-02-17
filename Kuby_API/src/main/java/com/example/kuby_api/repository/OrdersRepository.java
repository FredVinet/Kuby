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
            "lo.id_user, " +
            "ad.adress_id, ad.adress_number, ad.adress_country, ad.adress_state, ad.adress_name, ad.adress_city, ad.adress_code, " +
            "us.user_id, us.user_name, us.user_firstname, us.userType " +
            "FROM Orders o " +
            "JOIN Localisation lo ON o.id_localisation = lo.localisation_id " +
            "JOIN Adress ad ON lo.id_adress = ad.adress_id " +
            "JOIN User us ON lo.id_user = us.user_id ")

    List<Object[]> findAllOrdersWithDetails();

    @Query("SELECT o FROM Orders o JOIN Localisation l ON o.id_localisation = l.localisation_id WHERE l.id_user = :userId")
    List<Orders> findByUserId(@Param("userId") Integer userId);
}