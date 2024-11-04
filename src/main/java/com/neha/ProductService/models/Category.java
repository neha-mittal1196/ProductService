package com.neha.ProductService.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String title;
    //mappedBy is used when we dont want to use list in database but only in codebase
    //@OneToMany(mappedBy = "category") //(fetch = FetchType.EAGER)
    //private List<Product> products;
}
