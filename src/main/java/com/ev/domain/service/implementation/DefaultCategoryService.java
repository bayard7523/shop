package com.ev.domain.service.implementation;

import com.ev.domain.dto.CategoryDto;
import com.ev.domain.service.CategoryService;
import com.ev.persistence.entity.Category;
import com.ev.persistence.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DefaultCategoryService implements CategoryService {
	private final CategoryRepository categoryRepository;

	public DefaultCategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void save(CategoryDto categoryDto) {
		Category category = new Category();
		category.setTitle(categoryDto.getTitle());

		categoryRepository.save(category);
	}

	@Override
	public CategoryDto getCategoryById(long id) {
		return categoryRepository.findById(id).map(CategoryDto::new).orElse(null);
	}

	@Override
	public Set<CategoryDto> getCategories() {
		return categoryRepository.findAll().stream().map(CategoryDto::new).collect(Collectors.toSet());
	}

	@Override
	public void edit(CategoryDto CategoryDto) {

	}
}
