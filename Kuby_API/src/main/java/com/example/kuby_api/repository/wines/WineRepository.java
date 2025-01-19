package com.example.kuby_api.repository.wines;

import com.example.kuby_api.model.Wines.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineRepository extends JpaRepository<Wine, Long> {
    List<Wine> findByWineFamilyId(Long wineFamilyId);
    List<Wine> findByVariety(Long varietyId);
    List<Wine> findByTerroir(Long terroirId);
    List<Wine> findBySupplierId(Long supplierId);
}
