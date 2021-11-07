package com.ev.domain.dto;

import com.ev.model.CategoryData;
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
public class CategoryDto extends CategoryData {
	private Long id;
	private String title;
	private ImageDto image;
	private Set<SubCategoryDto> subCategories;

	public CategoryDto(CategoryData from) {
		super(from);
	}

	@Override
	public Set<SubCategoryData> getSubCategories() {
		return (subCategories == null) ? null : new HashSet<>(subCategories);
	}

	@Override
	public void setSubCategories(Set<SubCategoryData> subCategories) {
		this.subCategories = (subCategories == null) ? null : subCategories.stream().map(SubCategoryDto::new).collect(Collectors.toSet());
	}
}
