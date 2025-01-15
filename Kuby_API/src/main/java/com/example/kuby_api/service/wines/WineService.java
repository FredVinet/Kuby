package com.example.kuby_api.service.wines;

import com.example.kuby_api.model.Wines.Wine;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class WineService {
    public Wine getWineById(long wineId) {
        return null;
    }

    public List<Wine> getAllWines() {
        return null;
    }

    public List<Wine> getWineByWineFamilyId(long wineFamilyId) {
        return null;
    }

    public List<Wine> getWineByVarietyId(long varietyId) {
        return null;
    }

    public List<Wine> getWineByTerroirId(long terroirId) {
        return null;
    }

    public List<Wine> getWineBySupplierId(long wineId) {
        return null;
    }

    public Wine updateWine(long wineId, Wine wine) {
        return null;
    }

    public void deleteWine(long wineId) {
    }
}
