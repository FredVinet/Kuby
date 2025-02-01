package com.example.kuby_api.controller;

import com.example.kuby_api.model.Family;
import com.example.kuby_api.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @GetMapping("/families")
    public Iterable<Family> getFamilies() {
        return familyService.getFamilies();
    }
}
