package com.example.kuby_api.controller;

import com.example.kuby_api.model.Adress;
import com.example.kuby_api.model.Grape;
import com.example.kuby_api.service.GrapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/grapes")
public class GrapeController {

    @Autowired
    private GrapeService grapeService;

    @GetMapping
    public Iterable<Grape> getGrapes() {
        return grapeService.getGrapes();
    }
    @GetMapping("/{id}")
    public Optional<Grape> getGrapeById(@PathVariable Long id) {
        return grapeService.getGrape(id);
    }

    @PostMapping
    public Grape createGrape(@RequestBody Grape grape) {
        return grapeService.saveGrape(grape);
    }

    @PutMapping("/{id}")
    public Grape updateGrape(@PathVariable Long id, @RequestBody Grape grape) {
        grape.setGrape_id(id);
        return grapeService.saveGrape(grape);
    }

    @DeleteMapping("/{id}")
    public void deleteGrape(@PathVariable Long id) {
        grapeService.deleteGrape(id);
    }
}