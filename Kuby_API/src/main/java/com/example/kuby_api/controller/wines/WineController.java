package com.example.kuby_api.controller.wines;

import com.example.kuby_api.model.Wines.Wine;
import com.example.kuby_api.model.users.Supplier;
import com.example.kuby_api.service.users.SupplierService;
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
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/wine/byId/{wineId}")
    public ResponseEntity<?> getWineById(@PathVariable long wineId) {
        try {
            Wine wine = wineService.getWineById(wineId);
            return ResponseEntity.ok(wine);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (SecurityException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        //} catch (ResourceNotFoundException e) {
        //    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
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
    public ResponseEntity<?> getWineBySupplierId(@PathVariable long wineId) {
        try {
            Supplier supplier = supplierService.getSupplierByWineId(wineId);
            return ResponseEntity.ok(supplier);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/wine")
    public ResponseEntity<Wine> createWine(@RequestBody Wine wine) {
        Wine createdWine = wineService.createWine(wine);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWine);
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
