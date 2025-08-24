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

import com.demo.model.Category;
import com.demo.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private  CategoryService categoryService;
	
	@GetMapping
	public Page<Category>getAll(@RequestParam(defaultValue = "0") int page) {
		return categoryService.getAllCategories(PageRequest.of(page,10));
}
	
	@PostMapping(value = "/save")
	public Category save (@RequestBody
			Category category) {
		return categoryService.save(category);
		
	}
	
	@GetMapping("/{id}")
	public Category getById(@PathVariable Long id) {
		return categoryService.getById(id);
	}
	
	@PutMapping("/{id}")
	public Category update(@PathVariable Long id , 
			@RequestBody Category category) {
		return categoryService.update(id,category);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		categoryService.delete(id);
	}

}
