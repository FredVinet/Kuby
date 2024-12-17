package com.example.kuby_api.controller;

import com.example.kuby_api.model.Grape;
import com.example.kuby_api.service.GrapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrapeController {

    @Autowired
    private GrapeService grapeService;

    @GetMapping("/grapes")
    public Iterable<Grape> getGrapes() {
        return grapeService.getGrapes();
    }
}
