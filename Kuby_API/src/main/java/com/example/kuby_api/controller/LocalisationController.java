package com.example.kuby_api.controller;

import com.example.kuby_api.model.Localisation;
import com.example.kuby_api.service.LocalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalisationController {

    @Autowired
    private LocalisationService localisationService;

    @GetMapping("/localisations")
    public Iterable<Localisation> getLocalisations() {
        return localisationService.getLocalisations();
    }
}
