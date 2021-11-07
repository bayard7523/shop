package com.ev.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class ImageData {

	protected ImageData(ImageData from) {
		setId(from.getId());
		setTitle(from.getTitle());
		setImagePath(from.getImagePath());
	}

	public abstract Long getId();

	public abstract void setId(Long id);

	public abstract String getTitle();

	public abstract void setTitle(String title);

	public abstract String getImagePath();

	public abstract void setImagePath(String imagePath);


}
