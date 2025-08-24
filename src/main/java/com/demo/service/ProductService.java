package com.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.demo.model.Product;

public interface ProductService {

	
	Page<Product> getAllProducts(Pageable pageable);
	
	Product save(Product product);

	Product getById(Long id);

	Product update(Long id, Product product);

	void delete(Long id);


	

	

	
}
