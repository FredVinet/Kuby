package com.example.kuby_api.controller.wines;

import com.example.kuby_api.service.wines.WineQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WineQuantityController {
    @Autowired
    private WineQuantityService wineQuantityService;
}
