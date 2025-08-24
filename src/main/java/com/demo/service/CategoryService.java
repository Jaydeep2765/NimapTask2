package com.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.model.Category;

public interface CategoryService {

	Page<Category> getAllCategories(Pageable pageable);

	Category save(Category category);

	Category getById(Long id);

	Category update(Long id, Category category);

    void delete(Long id) ;
		
		
	}



