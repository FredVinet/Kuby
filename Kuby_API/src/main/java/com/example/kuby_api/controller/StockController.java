package com.example.kuby_api.controller;

import com.example.kuby_api.model.Stock;
import com.example.kuby_api.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/stocks")
    public Iterable<Stock> getStocks() {
        return stockService.getStocks();
    }
}
