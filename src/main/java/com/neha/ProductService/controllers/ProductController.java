package com.neha.ProductService.controllers;

import com.neha.ProductService.models.Product;
import com.neha.ProductService.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
       return productService.getProduct(id);
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }
}
