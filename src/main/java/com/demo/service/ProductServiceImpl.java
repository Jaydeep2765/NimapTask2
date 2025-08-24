package com.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductRepository;
import com.demo.model.Product;


@Service
public class ProductServiceImpl  implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	
	public Page<Product> getAllProducts(Pageable pageable) {
	return productRepository.findAll(pageable);
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product update(Long id , Product product) {
		Optional<Product> existing = productRepository.findById(id);
		if (existing.isPresent() ) {
			Product p = existing.get();
			p.setName(product.getName());
			p.setPrice(product.getPrice());
			p.setCategory(product.getCategory());
			return productRepository.save(p);
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);
		
	
		}

}
