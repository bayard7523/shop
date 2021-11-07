package com.ev.persistence.entity;

import com.ev.model.CategoryData;
import com.ev.model.ImageData;
import com.ev.model.ProductData;
import com.ev.model.SubCategoryData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "sub_categories", schema = "public")
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SubCategory extends SubCategoryData {
	@Id
	@SequenceGenerator(name = "sub_category", sequenceName = "sub_category_sequences", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sub_category")
	private Long id;

	@Column(name = "title", nullable = false, unique = true)
	private String title;

	@OneToOne(mappedBy = "subCategory", orphanRemoval = true)
	private Image image;

	@OneToMany(mappedBy = "subCategory")
	private Set<Product> products;

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH)
	private Category category;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	SubCategory(SubCategoryData from) {
		super(from);
	}

	@Override
	public void setImage(ImageData image) {
		this.image = new Image(image);
	}

	@Override
	public void setProducts(Set<ProductData> products) {
		this.products = (products == null) ? null : products.stream().map(Product::new).collect(Collectors.toSet());
	}

	@Override
	public void setCategory(CategoryData category) {
		this.category = (category == null) ? null : new Category(category);
	}
}
