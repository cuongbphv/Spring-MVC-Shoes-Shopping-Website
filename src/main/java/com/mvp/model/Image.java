package com.mvp.model;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class Image {

	private String productID;
	private int colorID;
	private byte[] image;
	private String base64;
	
	
	
	public Image(String productID, int colorID, byte[] image) {
		super();
		this.productID = productID;
		this.colorID = colorID;
		this.image = image;
		this.base64 = Base64.encode(image);
	}
	
	public String getBase64()
	{
		return this.base64;
	}
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public int getColorID() {
		return colorID;
	}
	public void setColorID(int colorID) {
		this.colorID = colorID;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
}
