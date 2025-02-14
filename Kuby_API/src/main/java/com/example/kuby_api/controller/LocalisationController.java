package com.example.kuby_api.controller;

import com.example.kuby_api.model.Localisation;
import com.example.kuby_api.model.Localisation;
import com.example.kuby_api.service.LocalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/localisations")
public class LocalisationController {

    @Autowired
    private LocalisationService localisationService;

    @GetMapping("/getAllLocalisations")
    public Iterable<Localisation> getLocalisations() {
        return localisationService.getLocalisations();
    }

    @GetMapping("/getOneLocalisation/{id}")
    public Optional<Localisation> getLocalisationById(@PathVariable Long id) {
        return localisationService.getLocalisation(id);
    }

    @PostMapping("/createLocalisation")
    public Localisation createLocalisation(@RequestBody Localisation localisation) {
        return localisationService.saveLocalisation(localisation);
    }

    @GetMapping("/getLocalisationByAdressId/{adressId}")
    public Localisation getLocalisationByAdressId(@PathVariable Long adressId) {
        return localisationService.getLocalisationByAdressId(adressId);
    }

    @PutMapping("/updateLocalisation/{id}")
    public Localisation updateLocalisation(@PathVariable Long id, @RequestBody Localisation localisation) {
        localisation.setLocalisation_id(id);
        return localisationService.saveLocalisation(localisation);
    }

    @DeleteMapping("/deleteLocalisation/{id}")
    public void deleteLocalisation(@PathVariable Long id) {
        localisationService.deleteLocalisation(id);
    }
}