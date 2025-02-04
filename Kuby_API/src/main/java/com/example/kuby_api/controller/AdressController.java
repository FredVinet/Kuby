package com.example.kuby_api.controller;
import com.example.kuby_api.model.Adress;
import com.example.kuby_api.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/adresses")
public class AdressController {

    @Autowired
    private AdressService adressService;

    @GetMapping
    public Iterable<Adress> getAdresses() {
        return adressService.getAdresses();
    }

    @GetMapping("/{id}")
    public Optional<Adress> getAdressById(@PathVariable Long id) {
        return adressService.getAdress(id);
    }

    @PostMapping
    public Adress createAdress(@RequestBody Adress adress) {
        return adressService.saveAdress(adress);
    }

    @PutMapping("/{id}")
    public Adress updateAdress(@PathVariable Long id, @RequestBody Adress adress) {
        adress.setAdress_id(id);
        return adressService.saveAdress(adress);
    }

    @DeleteMapping("/{id}")
    public void deleteAdress(@PathVariable Long id) {
        adressService.deleteAdress(id);
    }
}