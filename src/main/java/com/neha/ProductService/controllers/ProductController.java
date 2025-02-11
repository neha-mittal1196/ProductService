package com.neha.ProductService.controllers;

import com.neha.ProductService.commons.AuthCommons;
import com.neha.ProductService.dtos.UserDto;
import com.neha.ProductService.models.Product;
import com.neha.ProductService.models.Role;
import com.neha.ProductService.services.ProductService;
import exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
    private AuthCommons authCommons;

    public ProductController(@Qualifier("selfProductService") ProductService productService,
                             RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
        this.authCommons = new AuthCommons(restTemplate);
    }

    @GetMapping("/hello/{id}")
    public String sayHello(@PathVariable("id") String name) {
        return "Hello " + name;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        //Call UserService ValidateToken API to validate the token
       // UserDto userDto = authCommons.validateToken(token);

        ResponseEntity<Product> responseEntity;
//        if(userDto == null) {
//            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
//        }

        //Token is valid but we want to check Role based access.- We can add below code.

//        for(Role role : userDto.getRoles()) {
//            if(role.getValue().equals("ADMIN")) {
//                responseEntity = new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
//                return responseEntity;
//            }
//        }

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

