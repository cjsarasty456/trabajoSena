package com.sena.demo.model;

public class ImageResponse {
    private String imageName;
    private String imageData; // Aquí almacenarás la imagen en base64
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageData() {
		return imageData;
	}
	public void setImageData(String imageData) {
		this.imageData = imageData;
	}
    
    // Getters y setters
    
}