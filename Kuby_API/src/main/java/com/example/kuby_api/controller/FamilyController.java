package com.example.kuby_api.controller;

import com.example.kuby_api.model.Adress;
import com.example.kuby_api.model.Family;
import com.example.kuby_api.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/families")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @GetMapping
    public Iterable<Family> getFamilies() {
        return familyService.getFamilies();
    }

    @GetMapping("/{id}")
    public Optional<Family> getFamilyById(@PathVariable long id) {
        return familyService.getFamily(id);
    }

    @PostMapping
    public Family createFamily(@RequestBody Family family) {
        return familyService.saveFamily(family);
    }

    @PutMapping("/{id}")
    public Family updateFamily(@PathVariable long id, @RequestBody Family family) {
        family.setFamily_id(id);
        return familyService.saveFamily(family);
    }

    @DeleteMapping("/{id}")
    public void deleteFamily(@PathVariable long id) {
        familyService.deleteFamily(id);
    }
}