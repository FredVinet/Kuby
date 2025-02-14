package com.example.kuby_api.controller;

import com.example.kuby_api.model.SupplierArticle;
import com.example.kuby_api.service.SupplierArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplierarticles")
public class SupplierArticleController {

    @Autowired
    private SupplierArticleService supplierArticleService;

    @GetMapping("/byArticle/{articleId}")
    public List<SupplierArticle> getByArticleId(@PathVariable Long articleId) {
        return supplierArticleService.getSupplierArticlesByArticleId(articleId);
    }

    @GetMapping("/byUser/{userId}")
    public List<SupplierArticle> getByUserId(@PathVariable Long userId) {
        return supplierArticleService.getSupplierArticlesByUserId(userId);
    }
}
