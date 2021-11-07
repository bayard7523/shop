package com.ev.model;

import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
public abstract class SubCategoryData {

	protected SubCategoryData(SubCategoryData from) {
		setId(from.getId());
		setTitle(from.getTitle());
		setImage(from.getImage());
		setProducts(from.getProducts());
		setCategory(from.getCategory());
	}

	public abstract Long getId();

	public abstract void setId(Long id);

	public abstract String getTitle();

	public abstract void setTitle(String title);

	public abstract ImageData getImage();

	public abstract void setImage(ImageData image);

	public abstract Set<ProductData> getProducts();

	public abstract void setProducts(Set<ProductData> products);

	public abstract CategoryData getCategory();

	public abstract void setCategory(CategoryData category);
}
