package com.example.kuby_api.service;

import com.example.kuby_api.model.Stock;
import com.example.kuby_api.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import java.util.Optional;

@Data
@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Optional<Stock> getStock(final Long id){
        return stockRepository.findById(id);
    }

    public Iterable<Stock> getStocks() {
        return stockRepository.findAll();
    }

    public void deleteStock(final Long id){
        stockRepository.deleteById(id);
    }

    public Stock saveStock(Stock stock){
        return stockRepository.save(stock);
    }
}
