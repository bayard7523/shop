package com.ev.domain.dto;

import com.ev.model.ImageData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ImageDto extends ImageData {

	private Long id;
	private String title;
	private String imagePath;

	ImageDto(ImageData from) {
		super(from);
	}
}
