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
}
