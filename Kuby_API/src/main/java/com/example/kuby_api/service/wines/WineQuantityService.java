package com.example.kuby_api.service.wines;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class WineQuantityService {
    public Long getWineQuantityById(int wineId) {
        return null;
    }

    public Long getWineQuantityByWineFamilyId(int wineFamilyId) {
        return null;
    }

    public Long getWineQuantityByVarietyId(int varietyId) {
        return null;
    }

    public Long getWineQuantityByTerroirId(int terroirId) {
        return null;
    }

    public Long updateWineQuantity(int wineId, Long quantity) {
        return null;
    }
}
