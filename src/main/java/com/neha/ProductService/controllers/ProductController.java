package com.neha.ProductService.controllers;

import com.neha.ProductService.dtos.UserDto;
import com.neha.ProductService.models.Product;
import com.neha.ProductService.services.ProductService;
import exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private RestTemplate restTemplate;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService, RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/hello/{id}")
    public String sayHello(@PathVariable("id") String name) {
        return "Hello " + name;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {

        ResponseEntity<Product> responseEntity;
        //UserDto userDto = restTemplate.getForObject("http://userservice/users/10", UserDto.class);
        Product product =  productService.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);//product != null ? org.springframework.http.HttpStatus.OK : org.springframework.http.HttpStatus.NOT_FOUND);
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
}

