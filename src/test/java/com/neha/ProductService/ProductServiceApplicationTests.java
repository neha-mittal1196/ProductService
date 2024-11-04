package com.neha.ProductService;

import com.neha.ProductService.projections.ProductWithTitleAndDescription;
import com.neha.ProductService.repositories.CategoryRepository;
import com.neha.ProductService.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testTC() {
//		Optional<Category> optionalCategory = categoryRepository.findById(2L);
//		Category category = optionalCategory.get();
//		System.out.println("Fetching products related to above category");
//		List<Product> products = category.getProducts();
//		System.out.println(products.get(0).getTitle());

		ProductWithTitleAndDescription productWithTitleAndDescription = productRepository.someRandomQuery(1L);
		System.out.println("Product with HQL: " + productWithTitleAndDescription.getTitle()+ "," + productWithTitleAndDescription.getDescription());

		ProductWithTitleAndDescription productWithTitleAndDescription1 = productRepository.someOtherRandomQuery(2L);
		System.out.println("Product with SQL: " + productWithTitleAndDescription1.getTitle()+ "," + productWithTitleAndDescription1.getDescription());
	}

}
