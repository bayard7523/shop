package com.ev.domain.dto;

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
public class ProductDto extends ProductData {
	private Long id;
	private String title;
	private String description;
	private Set<ImageDto> images;
	private Integer price;
	private boolean isInStock;
	private SubCategoryDto subCategory;

	ProductDto(ProductData from) {
		super(from);
	}

	@Override
	public Set<ImageData> getImages() {
		return (images == null) ? null : new HashSet<>(images);
	}

	@Override
	public void setImages(Set<ImageData> images) {
		this.images = (images == null) ? null : images.stream().map(ImageDto::new).collect(Collectors.toSet());
	}

	@Override
	public void setSubCategory(SubCategoryData subCategory) {
		this.subCategory = (subCategory == null) ? null : new SubCategoryDto(subCategory);
	}
}
