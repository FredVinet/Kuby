package com.example.kuby_api.service.wines;

import com.example.kuby_api.model.Wines.Wine;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class WineService {
    public Wine getWineById(int wineId) {
        return null;
    }

    public List<Wine> getAllWines() {
        return null;
    }

    public List<Wine> getWineByWineFamilyId(long wineFamilyId) {
        return null;
    }

    public List<Wine> getWineByVarietyId(int varietyId) {
        return null;
    }

    public List<Wine> getWineByTerroirId(int terroirId) {
        return null;
    }

    public List<Wine> getWineBySupplierId(int wineId) {
        return null;
    }

    public Wine updateWine(int wineId, Wine wine) {
        return null;
    }

    public void deleteWine(int wineId) {
    }
}
