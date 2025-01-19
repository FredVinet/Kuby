package com.example.kuby_api.service.wines;

import com.example.kuby_api.model.Wines.Wine;
import com.example.kuby_api.repository.wines.WineRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
public class WineService {
    @Autowired
    WineRepository wineRepository;

    public Wine getWineById(long wineId) {
        return wineRepository.findById(wineId)
                .orElseThrow(() -> new NoSuchElementException("Wine not found with id: " + wineId));
    }

    public List<Wine> getAllWines() {
        return wineRepository.findAll();
    }

    public List<Wine> getWineByWineFamilyId(long wineFamilyId) {
        List<Wine> wines = wineRepository.findByWineFamilyId(wineFamilyId);
        if (wines.isEmpty()) {
            throw new NoSuchElementException("No wines found for wine family id: " + wineFamilyId);
        }
        return wines;
    }

    public List<Wine> getWineByVarietyId(long varietyId) {
        List<Wine> wines = wineRepository.findByVariety(varietyId);
        if (wines.isEmpty()) {
            throw new NoSuchElementException("No wines found for variety id: " + varietyId);
        }
        return wines;
    }

    public List<Wine> getWineByTerroirId(long terroirId) {
        List<Wine> wines = wineRepository.findByTerroir(terroirId);
        if (wines.isEmpty()) {
            throw new NoSuchElementException("No wines found for terroir id: " + terroirId);
        }
        return wines;
    }

    public List<Wine> getWineBySupplierId(long supplierId) {
        List<Wine> wines = wineRepository.findBySupplierId(supplierId);
        if (wines.isEmpty()) {
            throw new NoSuchElementException("No wines found for supplier id: " + supplierId);
        }
        return wines;
    }

    public Wine createWine(Wine wine) {
        return wineRepository.save(wine);
    }

    public Wine updateWine(long wineId, Wine wine) {
        if (!wineRepository.existsById(wineId)) {
            throw new NoSuchElementException("Wine not found with id: " + wineId);
        }
        wine.setId(wineId);
        return wineRepository.save(wine);
    }

    public void deleteWine(long wineId) {
        if (!wineRepository.existsById(wineId)) {
            throw new NoSuchElementException("Wine not found with id: " + wineId);
        }
        wineRepository.deleteById(wineId);
    }
}
