package com.example.kuby_api.repository.wines;

import com.example.kuby_api.model.Wines.WineTerroir;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWineTerroirRepository extends JpaRepository<WineTerroir, Long> {
}
