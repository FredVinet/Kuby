package com.example.kuby_api.controller.wines;

import com.example.kuby_api.model.Wines.Wine;
import com.example.kuby_api.service.wines.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WineController {
    @Autowired
    private WineService wineService;

    @GetMapping("/wine/byId/{wineId}")
    public ResponseEntity<Wine> getWineById(@PathVariable int wineId) {
        try {
            return ResponseEntity.ok(wineService.getWineById(wineId));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/wines")
    public ResponseEntity<List<Wine>> getAllWines() {
        try{
            return ResponseEntity.ok(wineService.getAllWines());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/wine/byWineFamily/{wineFamilyId}")
    public ResponseEntity<List<Wine>> getWineByWineFamilyId(@PathVariable int wineFamilyId) {
        try {
            return ResponseEntity.ok(wineService.getWineByWineFamilyId(wineFamilyId));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/wine/byVariety/{varietyId}")
    public ResponseEntity<List<Wine>> getWineByVarietyId(@PathVariable int varietyId) {
        try {
            return ResponseEntity.ok(wineService.getWineByVarietyId(varietyId));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/wine/byTerroir/{terroirId}")
    public ResponseEntity<List<Wine>> getWineByTerroirId(@PathVariable int terroirId) {
        try{
            return ResponseEntity.ok(wineService.getWineByTerroirId(terroirId));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/wine/bySupplier/{wineId}")
    public ResponseEntity<List<Wine>> getWineBySupplierId(@PathVariable int wineId) {
        try {
            return ResponseEntity.ok(wineService.getWineBySupplierId(wineId));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/wine")
    public ResponseEntity<Wine> createWine(@RequestBody Wine wine) {
        return ResponseEntity.status(HttpStatus.CREATED).body(wine);
    }

    @PutMapping("/wine/{wineId}")
    public ResponseEntity<Wine> updateWine(@PathVariable int wineId, @RequestBody Wine wine) {
        if (wine.getId() != wineId) {
            return ResponseEntity.badRequest().build();
        }

        try {
            return ResponseEntity.ok(wineService.updateWine(wineId, wine));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/wine/{wineId}")
    public ResponseEntity<Wine> deleteWine(@PathVariable int wineId) {
        try {
            wineService.deleteWine(wineId);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
