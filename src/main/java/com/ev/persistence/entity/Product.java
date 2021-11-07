package com.ev.persistence.entity;

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
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "products", schema = "public")
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Product extends ProductData {
	@Id
	@SequenceGenerator(name = "product", sequenceName = "product_sequences", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product")
	private Long id;

	@Column(name = "title", unique = true, nullable = false)
	private String title;

	@Column(name = "description", unique = false, nullable = true)
	private String description;

	@OneToMany(mappedBy = "product")
	private Set<Image> images;

	@Column(name = "price", unique = false, nullable = false)
	private Integer price;

	@Column(name = "is_in_stock", unique = false, nullable = false)
	private boolean isInStock;

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "sub_category_id", nullable = false)
	private SubCategory subCategory;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	Product(ProductData from) {
		super(from);
	}

	@Override
	public Set<ImageData> getImages() {
		return (images == null) ? null : new HashSet<>(images);
	}

	@Override
	public void setImages(Set<ImageData> images) {
		this.images = (images == null) ? null : images.stream().map(Image::new).collect(Collectors.toSet());
	}

	@Override
	public void setSubCategory(SubCategoryData subCategory) {
		this.subCategory = (subCategory == null) ? null : new SubCategory(subCategory);
	}
}
