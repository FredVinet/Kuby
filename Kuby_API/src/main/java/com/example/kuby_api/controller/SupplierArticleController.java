package com.example.kuby_api.controller;

import com.example.kuby_api.model.SupplierArticle;
import com.example.kuby_api.model.SupplierArticle;
import com.example.kuby_api.service.SupplierArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/supplierarticles")
public class SupplierArticleController {

    @Autowired
    private SupplierArticleService supplierArticleService;

    @GetMapping("/getAllSupplierArticles")
    public Iterable<SupplierArticle> getSupplierArticles() {
        return supplierArticleService.getSupplierArticles();
    }

    @GetMapping("/getOneSupplierArticle/{id}")
    public Optional<SupplierArticle> getSupplierArticleById(@PathVariable Long id) {
        return supplierArticleService.getSupplierArticle(id);
    }

    @PostMapping("/createSupplierArticle")
    public SupplierArticle createSupplierArticle(@RequestBody SupplierArticle supplierArticle) {
        System.out.println("Received SupplierArticle: " + supplierArticle);
        return supplierArticleService.saveSupplierArticle(supplierArticle);
    }

    @PutMapping("/updateSupplierArticle/{id}")
    public SupplierArticle updateSupplierArticle(@PathVariable Long id, @RequestBody SupplierArticle supplierArticle) {
        supplierArticle.setSupplier_article_id(id);
        return supplierArticleService.saveSupplierArticle(supplierArticle);
    }

    @DeleteMapping("/deleteSupplierArticle/{id}")
    public void deleteSupplierArticle(@PathVariable Long id) {
        supplierArticleService.deleteSupplierArticle(id);
    }
}