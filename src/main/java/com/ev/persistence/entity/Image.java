package com.ev.persistence.entity;

import com.ev.model.ImageData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "images", schema = "public")
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Image extends ImageData {
	@Id
	@SequenceGenerator(name = "image", sequenceName = "image_sequences", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image")
	private Long id;

	@Column(name = "title", unique = true, nullable = false)
	private String title;

	@Column(name = "image_path", unique = false, nullable = false)
	private String imagePath;

	@ManyToOne(optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@OneToOne
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

	Image(ImageData from) {
		super(from);
	}
}
