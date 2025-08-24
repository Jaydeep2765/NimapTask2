package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Product;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page){
	    return productService.getAllProducts(PageRequest.of(page, 10));
	}
	
	
	@PostMapping(value = "/add")
	public Product save(@RequestBody
			Product product) {
		return productService.save(product);
	}
	
	
	@GetMapping("/{id}")
	public Product getById(@PathVariable Long id) {
		return productService.getById(id);
	}
	
	
	@PutMapping("/{id}")
	public Product update(@PathVariable Long id , @RequestBody Product product)
	{
		return productService.update(id , product );	
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		productService.delete(id);
	}
	


}
