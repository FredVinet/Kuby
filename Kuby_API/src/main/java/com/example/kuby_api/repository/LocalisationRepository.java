package com.example.kuby_api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.kuby_api.model.Localisation;

import java.util.List;

@Repository
public interface LocalisationRepository extends CrudRepository<Localisation, Long> {
    @Query("SELECT l FROM Localisation l WHERE l.id_user = :userId")
    List<Localisation> findByUserId(@Param("userId") Integer userId);
}