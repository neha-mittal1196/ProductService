package com.neha.ProductService.repositories;

import com.neha.ProductService.models.Product;
import com.neha.ProductService.projections.ProductWithTitleAndDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long id);

    List<Product> findByTitle(String title);

    List<Product> findByTitleContains(String str);
    void deleteById(Product product);

    @Override
    Product save(Product product);

    //HQL - mix of SQL and hibernate
    //Here title and description aliases should exactly match with methods in Projections
    @Query("select p.title as title, p.description as description from Product p where p.id = :id")
    ProductWithTitleAndDescription someRandomQuery(@Param("id") Long id);//create and update

    //SQL Queries are also known as native queries
    @Query(value = "select title, description from product as p where p.id = :id", nativeQuery = true)
    ProductWithTitleAndDescription someOtherRandomQuery
            (@Param("id") Long id);
}

