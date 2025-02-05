package com.example.kuby_api.controller;

import com.example.kuby_api.model.Stock;
import com.example.kuby_api.model.Stock;
import com.example.kuby_api.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/getAllStocks")
    public Iterable<Stock> getStocks() {
        return stockService.getStocks();
    }

    @GetMapping("/getOneStock/{id}")
    public Optional<Stock> getStockById(@PathVariable Long id) {
        return stockService.getStock(id);
    }

    @PostMapping("/createStock")
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.saveStock(stock);
    }

    @PutMapping("/updateStock/{id}")
    public Stock updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        stock.setStock_id(id);
        return stockService.saveStock(stock);
    }

    @DeleteMapping("/deleteStock/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }
}