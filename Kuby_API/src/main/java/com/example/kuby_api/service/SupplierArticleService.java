package com.example.kuby_api.service;

import com.example.kuby_api.model.SupplierArticle;
import com.example.kuby_api.repository.SupplierArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierArticleService {

    @Autowired
    private SupplierArticleRepository supplierArticleRepository;

    public List<SupplierArticle> getSupplierArticlesByArticleId(Long articleId) {
        return supplierArticleRepository.findByArticleId(articleId);
    }

    private void deleteSupplierArticle(Long id) {
        supplierArticleRepository.deleteById(id);
    }

    public void deleteSupplierArticlesByArticleId(Long articleId) {
        supplierArticleRepository.deleteByArticleId(articleId);
    }

    public List<SupplierArticle> getSupplierArticlesByUserId(Long userId) {
        return supplierArticleRepository.findByUserId(userId);
    }

    public SupplierArticle saveSupplierArticle(SupplierArticle supplierArticle) {
        return supplierArticleRepository.save(supplierArticle);
    }
}
