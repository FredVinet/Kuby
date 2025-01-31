package com.example.kuby_api.controller.wines;

import com.example.kuby_api.model.Wines.Wine;
import com.example.kuby_api.model.Wines.WineFamily;
import com.example.kuby_api.model.Wines.WineTerroir;
import com.example.kuby_api.model.Wines.WineVariety;
import com.example.kuby_api.model.users.Supplier;
import com.example.kuby_api.service.users.SupplierService;
import com.example.kuby_api.service.wines.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class WineController {
    @Autowired
    private WineService wineService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/wine/byId/{wineId}")
    public ResponseEntity<?> getWineById(@PathVariable long wineId) {
        try {
            Wine wine = wineService.getWineById(wineId);
            return ResponseEntity.ok(wine);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (SecurityException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

    @GetMapping("/test")
    public String test() {
        try {
            String result = jdbcTemplate.queryForObject("SELECT * FROM test", String.class);
            return result;
        }catch (Exception e) {
            return "trop null" + e.getMessage() + "----" + e.getCause() + "----" + e.getStackTrace();
       }
    }

    @GetMapping("/wines")
    public ResponseEntity<List<Wine>> getAllWines() {
        try{
            return ResponseEntity.ok(wineService.getAllWines());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build(); // TODO mettre INTERNAL_SERVER_ERROR (500)
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

    @GetMapping("/wine/SupplierByWine/{wineId}")
    public ResponseEntity<Supplier> getSupplierByWine(@PathVariable long wineId) {
        try {
            Supplier supplier = (Supplier) wineService.getSupplierByWine(wineId);
            return ResponseEntity.ok(supplier);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/wine/byYear")
    public ResponseEntity<List<Wine>> getWineByYear(@RequestParam int year) {
        try{
            return ResponseEntity.ok(wineService.getWineByYear(year));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/wine/AllFamilly")
    public ResponseEntity<List<WineFamily>> getAllFamilly() {
        try {
            return ResponseEntity.ok(wineService.getAllFamilly());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/wine/AllVariety")
    public ResponseEntity<List<WineVariety>> getAllVariety() {
        try{
            return ResponseEntity.ok(wineService.getAllVariety());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/wine/AllTerroir")
    public ResponseEntity<List<WineTerroir>> getAllTerroir() {
        try {
            return ResponseEntity.ok(wineService.getAllTerroir());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
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



    //TODO rajouter les endpoints pour récupérer les variété, terroir et family
}
