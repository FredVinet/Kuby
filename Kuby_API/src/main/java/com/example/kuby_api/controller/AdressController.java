package com.example.kuby_api.controller;
import com.example.kuby_api.model.Adress;
import com.example.kuby_api.model.Localisation;
import com.example.kuby_api.service.AdressService;
import com.example.kuby_api.service.LocalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/adresses")
public class AdressController {

    @Autowired
    private AdressService adressService;

    @Autowired
    private LocalisationService localisationService;

    @GetMapping("/getAllAdresses")
    public Iterable<Adress> getAdresses() {
        return adressService.getAdresses();
    }

    @GetMapping("/getOneAdress/{id}")
    public Optional<Adress> getAdressById(@PathVariable Long id) {
        return adressService.getAdress(id);
    }

    @PostMapping("/createAdress")
    public Adress createAdress(@RequestBody Adress adress) {
        return adressService.saveAdress(adress);
    }

    @PostMapping("/createUserAdress/{userId}")
    public ResponseEntity<Map<String, Object>> createUserAdress(@PathVariable Long userId, @RequestBody Adress adress) {

        // Créer l'adresse
        Adress savedAdress = adressService.saveAdress(adress);

        // Créer la localisation associée
        Localisation localisation = new Localisation();
        localisation.setId_user(userId);
        localisation.setId_adress(savedAdress.getAdress_id());
        Localisation savedLocalisation = localisationService.saveLocalisation(localisation);

        // Retourner les deux objets créés
        Map<String, Object> response = new HashMap<>();
        response.put("adress", savedAdress);
        response.put("localisation", savedLocalisation);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/updateAdress/{id}")
    public Adress updateAdress(@PathVariable Long id, @RequestBody Adress adress) {
        adress.setAdress_id(id);
        return adressService.saveAdress(adress);
    }

    @DeleteMapping("/deleteAdress/{id}")
    public void deleteAdress(@PathVariable Long id) {
        adressService.deleteAdress(id);
    }
}