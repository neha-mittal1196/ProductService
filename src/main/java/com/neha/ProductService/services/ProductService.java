package com.neha.ProductService.services;

import com.neha.ProductService.models.Product;
import java.util.List;

public interface ProductService {
    Product getProduct(Long id);
    List<Product> getAllProducts();
    Product replaceProduct(Long id, Product product);
}
