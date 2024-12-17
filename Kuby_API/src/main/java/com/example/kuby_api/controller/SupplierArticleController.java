package com.example.kuby_api.controller;

import com.example.kuby_api.model.SupplierArticle;
import com.example.kuby_api.service.SupplierArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierArticleController {

    @Autowired
    private SupplierArticleService supplierArticleService;

    @GetMapping("/supplierarticles")
    public Iterable<SupplierArticle> getSupplierArticles() {
        return supplierArticleService.getSupplierArticles();
    }
}
