package com.neha.ProductService.services;

import com.neha.ProductService.models.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {
    Product getProduct(Long id);
    List<Product> getAllProducts();
}
