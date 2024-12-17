package com.example.kuby_api.controller;

import com.example.kuby_api.model.Adress;
import com.example.kuby_api.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdressController {

    @Autowired
    private AdressService adressService;

    @GetMapping("/adresses")
    public Iterable<Adress> getAdresses() {
        return adressService.getAdresses();
    }
}
