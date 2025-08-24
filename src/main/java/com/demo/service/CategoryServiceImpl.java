package com.demo.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.dao.CategoryRepository;
import com.demo.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository
	categoryRepository;
	
	
	@Override
	public Page<Category>
	getAllCategories(Pageable pageable){
		
		return categoryRepository.findAll(pageable);
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category getById(Long id) {
		return categoryRepository.findById(id)
		.orElseThrow(()-> new
				RuntimeException("category not found with id:" +id));
	}

	@Override
	public Category update(Long id, Category category) {
		Optional<Category> existing = categoryRepository.findById(id);
        if (existing.isPresent()) {
            Category c = existing.get();
            c.setName(category.getName());
		return categoryRepository.save(c);
	}
        return null;
	}
	
	@Override
	public void delete(Long id) {
		if(!categoryRepository.existsById(id)) {
			throw new RuntimeException("category not found by id:" +id);
		}
		categoryRepository.deleteById(id);
	}
 
}
