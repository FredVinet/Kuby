package com.example.kuby_api.repository.wines;

import com.example.kuby_api.model.Wines.WineFamily;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWineFamilyRepository extends JpaRepository<WineFamily,Long> {
}
