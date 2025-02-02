package com.neha.ProductService.controllers;

import com.neha.ProductService.models.Category;
import com.neha.ProductService.models.Product;
import com.neha.ProductService.repositories.ProductRepository;
import com.neha.ProductService.services.ProductService;
import exceptions.ProductNotFoundException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@Disabled
@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;
    @MockBean //This is going to be mocked object
    private ProductService productService;
    @MockBean
    ProductRepository productRepository;

    @Test
    void validGetProductByIdTest() throws ProductNotFoundException {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Macbook pro");
        product.setPrice(15000);

        when(productService.getProduct(1L)).thenReturn(product);

        Product actualProduct = productController.getProductById(1L).getBody();
        assertEquals(product, actualProduct);
    }

    @Test
    void testGetAllProducts() {
        List<Product> expectedProducts = new ArrayList<>();

        Product p1 = new Product();
        p1.setId(1L);
        p1.setTitle("Phone1");

        Product p2 = new Product();
        p1.setId(2L);
        p1.setTitle("Phone2");

        Product p3 = new Product();
        p1.setId(3L);
        p1.setTitle("Phone3");

        expectedProducts.add(p1);
        expectedProducts.add(p2);
        expectedProducts.add(p3);

        when(productService.getAllProducts()).thenReturn(expectedProducts);
        List<Product> products = productController.getAllProducts();

        assertIterableEquals(expectedProducts, products);
    }

    @Test
    void testInvalidGetProductByIdTest() throws ProductNotFoundException {
        Product product = new Product();
        product.setId(1L);
        Category category = new Category();
        product.setCategory(category);

        when(productService.getProduct(100L)).thenThrow(new ProductNotFoundException(100L, "Product not found"));
        assertThrows(ProductNotFoundException.class, ()-> productController.getProductById(100L));
       // assertThrows(ProductNotFoundException.class, ()-> productController.createProduct(product));
    }
}