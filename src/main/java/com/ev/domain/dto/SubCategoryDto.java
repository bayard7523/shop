package com.ev.domain.dto;

import com.ev.model.CategoryData;
import com.ev.model.ImageData;
import com.ev.model.ProductData;
import com.ev.model.SubCategoryData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SubCategoryDto extends SubCategoryData {
	private Long id;
	private String title;
	private ImageDto image;
	private Set<ProductDto> products;
	private CategoryDto category;

	SubCategoryDto(SubCategoryData from) {
		super(from);
	}

	@Override
	public void setImage(ImageData image) {
		this.image = (image == null) ? null : new ImageDto(image);
	}

	@Override
	public Set<ProductData> getProducts() {
		return (products == null) ? null : new HashSet<>(products);
	}

	@Override
	public void setProducts(Set<ProductData> products) {
		this.products = (products == null) ? null : products.stream().map(ProductDto::new).collect(Collectors.toSet());
	}

	@Override
	public void setCategory(CategoryData category) {
		this.category = (category == null) ? null : new CategoryDto(category);
	}
}
