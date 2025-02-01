package com.example.kuby_api.repository.wines;

import com.example.kuby_api.model.Wines.WineVariety;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWineVarietyRepository extends JpaRepository<WineVariety, Long> {
}
