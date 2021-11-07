package com.ev.persistence.entity;

import com.ev.model.ImageData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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
	private Product product;

	Image(ImageData from) {
		super(from);
	}
}
