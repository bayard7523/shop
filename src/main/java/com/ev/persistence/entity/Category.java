package com.ev.persistence.entity;

import com.ev.model.CategoryData;
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
@Table(name = "categories", schema = "public")
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Category extends CategoryData {
	@Id
	@SequenceGenerator(name = "category", sequenceName = "category_sequences", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category")
	private Long id;

	@Column(name = "title", nullable = false, unique = true)
	private String title;

	@OneToMany(mappedBy = "category")
	private Set<SubCategory> subCategories;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	Category(CategoryData from) {
		super(from);
	}

	@Override
	public void setSubCategories(Set<SubCategoryData> subCategories) {
		this.subCategories = (subCategories == null) ? null : subCategories.stream().map(SubCategory::new).collect(Collectors.toSet());
	}
}