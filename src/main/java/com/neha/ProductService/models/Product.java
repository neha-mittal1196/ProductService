package com.neha.ProductService.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private Long id;
    private String title;
    private double price;
    private Category category; // EAGER FETCH
    private String description;
    private String image;
}
