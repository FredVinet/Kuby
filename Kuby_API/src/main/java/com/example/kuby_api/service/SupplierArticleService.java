package com.example.kuby_api.service;

import com.example.kuby_api.model.SupplierArticle;
import com.example.kuby_api.repository.SupplierArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import java.util.Optional;

@Data
@Service
public class SupplierArticleService {

    @Autowired
    private SupplierArticleRepository supplierArticleRepository;

    public Optional<SupplierArticle> getSupplierArticle(final Long id){
        return supplierArticleRepository.findById(id);
    }

    public Iterable<SupplierArticle> getSupplierArticles() {
        return supplierArticleRepository.findAll();
    }

    public void deleteSupplierArticle(final Long id){
        supplierArticleRepository.deleteById(id);
    }

    public SupplierArticle saveSupplierArticle(SupplierArticle supplierArticle){
        return supplierArticleRepository.save(supplierArticle);
    }
}