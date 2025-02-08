package com.example.kuby_api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.kuby_api.model.Adress;

import java.util.List;

@Repository
public interface AdressRepository extends CrudRepository<Adress, Long> {
    @Query("SELECT a FROM Adress a JOIN Localisation l ON a.adress_id = l.id_adress WHERE l.id_user = :userId")
    List<Adress> findByUserId(@Param("userId") Integer userId);
}