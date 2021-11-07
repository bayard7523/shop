package com.ev.domain.service;

import com.ev.domain.dto.CategoryDto;

import java.util.Set;

public interface CategoryService {
	void save(CategoryDto categoryDto);

	CategoryDto getCategoryById(long id);

	Set<CategoryDto> getCategories();

	void edit(CategoryDto CategoryDto);
}
