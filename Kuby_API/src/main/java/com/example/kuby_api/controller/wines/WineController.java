package com.example.kuby_api.controller.wines;

import com.example.kuby_api.model.Wines.Wine;
import com.example.kuby_api.service.wines.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
