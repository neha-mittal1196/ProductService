package com.neha.ProductService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private double price;
    private String description;
    private String image;
    @ManyToOne(cascade = CascadeType.DETACH)
    @Fetch(FetchMode.SELECT)
    @JoinColumn
    private Category category; // EAGER FETCH
}
