package com.neha.ProductService.services;

import com.neha.ProductService.models.Product;
import exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    Product getProduct(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product replaceProduct(Long id, Product product);
}
