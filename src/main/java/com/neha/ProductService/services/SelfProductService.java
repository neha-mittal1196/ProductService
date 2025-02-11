package com.neha.ProductService.services;

import com.neha.ProductService.models.Category;
import com.neha.ProductService.models.Product;
import com.neha.ProductService.repositories.CategoryRepository;
import com.neha.ProductService.repositories.ProductRepository;
import exceptions.ProductNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Primary
@Service("selfProductService")
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }



    @Override
    public Product getProduct(Long id) throws ProductNotFoundException {
        //It will return product by doing left join of product with category.
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()) {
            throw new ProductNotFoundException(id, "Product not found");
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if(category.getId() == null) {
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }

        Product savedProduct =  productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(savedProduct.getCategory().getId());
        Category category1 = optionalCategory.get();
        savedProduct.setCategory(category1);
        return savedProduct;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
