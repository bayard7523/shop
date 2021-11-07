package com.ev.model;

import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
public abstract class ProductData {

	protected ProductData(ProductData from) {
		setId(from.getId());
		setTitle(from.getTitle());
		setDescription(from.getDescription());
		setImages(from.getImages());
		setPrice(from.getPrice());
		setInStock(from.isInStock());
		setSubCategory(from.getSubCategory());
	}

	public abstract Long getId();

	public abstract void setId(Long id);

	public abstract String getTitle();

	public abstract void setTitle(String title);

	public abstract String getDescription();

	public abstract void setDescription(String description);

	public abstract Set<ImageData> getImages();

	public abstract void setImages(Set<ImageData> images);

	public abstract Integer getPrice();

	public abstract void setPrice(Integer price);

	public abstract boolean isInStock();

	public abstract void setInStock(boolean isInStock);

	public abstract SubCategoryData getSubCategory();

	public abstract void setSubCategory(SubCategoryData subCategory);
}
