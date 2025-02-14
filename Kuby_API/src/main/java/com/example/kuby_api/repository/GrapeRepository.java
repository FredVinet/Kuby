package com.example.kuby_api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.kuby_api.model.Grape;

import java.util.List;

@Repository
public interface GrapeRepository extends CrudRepository<Grape, Long> {

    @Query("SELECT g FROM Grape g JOIN Article a ON g.grape_id = a.id_grape WHERE a.id_grape = :idGrape")
    List<Grape> findByArticleIdGrape(@Param("idGrape") Long idGrape);
}
