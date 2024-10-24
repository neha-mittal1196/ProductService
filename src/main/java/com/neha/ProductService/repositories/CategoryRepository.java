package com.neha.ProductService.repositories;

import com.neha.ProductService.models.Category;
import com.neha.ProductService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
