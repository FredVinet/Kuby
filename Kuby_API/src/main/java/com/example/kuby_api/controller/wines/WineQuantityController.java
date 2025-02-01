package com.example.kuby_api.controller.wines;

import com.example.kuby_api.service.wines.WineQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WineQuantityController {
    @Autowired
    private WineQuantityService wineQuantityService;

    @GetMapping("/wine/quantity/{wineId}")
    public ResponseEntity<Long> getWineQuantityById(@PathVariable int wineId) {
        try {
            return ResponseEntity.ok(wineQuantityService.getWineQuantityById(wineId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/wine/quantity/byWineFamily/{wineFamilyId}")
    public ResponseEntity<Long> getWineQuantityByWineFamily(@PathVariable int wineFamilyId) {
        try {
            return ResponseEntity.ok(wineQuantityService.getWineQuantityByWineFamilyId(wineFamilyId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/wine/quantity/byVariety/{varietyId}")
    public ResponseEntity<Long> getWineQuantityByVariety(@PathVariable int varietyId) {
        try {
            return ResponseEntity.ok(wineQuantityService.getWineQuantityByVarietyId(varietyId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/wine/quantity/byTerroir/{terroirId}")
    public ResponseEntity<Long> getWineQuantityByTerroir(@PathVariable int terroirId) {
        try {
            return ResponseEntity.ok(wineQuantityService.getWineQuantityByTerroirId(terroirId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/wine/quantity/{wineId}")
    public ResponseEntity<Long> updateWineQuantity(@PathVariable int wineId, @RequestBody Long quantity) {
        try {
            Long updatedQuantity = wineQuantityService.updateWineQuantity(wineId, quantity);
            return ResponseEntity.ok(updatedQuantity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}