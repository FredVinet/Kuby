package com.example.kuby_api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.kuby_api.model.Family;

import java.util.List;

@Repository
public interface FamilyRepository extends CrudRepository<Family, Long> {

    @Query("SELECT f FROM Family f JOIN Article a ON f.family_id = a.id_family WHERE a.id_family = :idFamily")
    List<Family> findByArticleIdFamily(@Param("idFamily") Long idFamily);
}
