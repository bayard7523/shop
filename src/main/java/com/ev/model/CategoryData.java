package com.ev.model;

import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
public abstract class CategoryData {

	protected CategoryData(CategoryData from) {
		setId(from.getId());
		setTitle(from.getTitle());
		setSubCategories(from.getSubCategories());
	}

	public abstract Long getId();

	public abstract void setId(Long id);

	public abstract String getTitle();

	public abstract void setTitle(String title);

	public abstract Set<SubCategoryData> getSubCategories();

	public abstract void setSubCategories(Set<SubCategoryData> subCategories);
}

