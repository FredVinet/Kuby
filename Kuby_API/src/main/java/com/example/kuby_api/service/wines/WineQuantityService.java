package com.example.kuby_api.service.wines;

import com.example.kuby_api.model.Wines.Wine;
import com.example.kuby_api.repository.wines.IWineRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
public class WineQuantityService {
    @Autowired
    private IWineRepository wineRepository;

    public Long getWineQuantityById(long wineId) {
        Wine wine = wineRepository.findById(wineId)
                .orElseThrow(() -> new NoSuchElementException("Wine not found with id: " + wineId));
        return wine.getStock();
    }

    public Long getWineQuantityByWineFamilyId(long wineFamilyId) {
        List<Wine> wines = wineRepository.findByWineFamilyId(wineFamilyId);
        return wines.stream()
                .mapToLong(Wine::getStock)
                .sum();
    }

    public Long getWineQuantityByVarietyId(long varietyId) {
        List<Wine> wines = wineRepository.findByVarietyId(varietyId);
        return wines.stream()
                .mapToLong(Wine::getStock)
                .sum();
    }

    public Long getWineQuantityByTerroirId(long terroirId) {
        List<Wine> wines = wineRepository.findByTerroirId(terroirId);
        return wines.stream()
                .mapToLong(Wine::getStock)
                .sum();
    }

    public Long updateWineQuantity(long wineId, Long quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        Wine wine = wineRepository.findById(wineId)
                .orElseThrow(() -> new NoSuchElementException("Wine not found with id: " + wineId));

        wine.setStock(quantity);
        wine = wineRepository.save(wine);
        return wine.getStock();

        //TODO penser à gérer les commandes fournisseur si quantity <= 0 grace à @Transactional
    }
}
