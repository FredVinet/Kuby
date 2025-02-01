package com.example.kuby_api.service.wines;

import com.example.kuby_api.model.Wines.Wine;
import com.example.kuby_api.model.Wines.WineFamily;
import com.example.kuby_api.model.Wines.WineTerroir;
import com.example.kuby_api.model.Wines.WineVariety;
import com.example.kuby_api.repository.wines.IWineFamilyRepository;
import com.example.kuby_api.repository.wines.IWineRepository;
import com.example.kuby_api.repository.wines.IWineTerroirRepository;
import com.example.kuby_api.repository.wines.IWineVarietyRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
public class WineService {
    @Autowired
    IWineRepository wineRepository;
    @Autowired
    IWineFamilyRepository familyRepository;
    @Autowired
    IWineVarietyRepository varietyRepository;
    @Autowired
    IWineTerroirRepository terroirRepository;

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
        List<Wine> wines = wineRepository.findByVarietyId(varietyId);
        if (wines.isEmpty()) {
            throw new NoSuchElementException("No wines found for variety id: " + varietyId);
        }
        return wines;
    }

    public List<Wine> getWineByTerroirId(long terroirId) {
        List<Wine> wines = wineRepository.findByTerroirId(terroirId);
        if (wines.isEmpty()) {
            throw new NoSuchElementException("No wines found for terroir id: " + terroirId);
        }
        return wines;
    }

    public List<Wine> getSupplierByWine(long supplierId) {
        List<Wine> wines = wineRepository.findBySupplierId(supplierId);
        if (wines.isEmpty()) {
            throw new NoSuchElementException("No wines found for supplier id: " + supplierId);
        }
        return wines;
    }

    public List<Wine> getWineByYear(int year) {
        List<Wine> wines = wineRepository.findByYear(year);
        if (wines.isEmpty()) {
            throw new NoSuchElementException("No wines found for year: " + year);
        }
        return wines;
    }

    public List<WineFamily> getAllFamilly() {return familyRepository.findAll();}

    public List<WineVariety> getAllVariety() {return varietyRepository.findAll();}

    public List<WineTerroir> getAllTerroir() {return terroirRepository.findAll();}

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
