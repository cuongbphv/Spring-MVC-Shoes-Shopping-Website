package com.mvp.model;

import com.mvp.DAO.ColorDAO;
import com.mvp.DAO.ProductDAO;
import com.mvp.services.ColorServices;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class ProductImage {
	private String pID;
	private int cID;
	private byte[] image;
	private int keyID;

	private String base64;
	private Product product;
	private Color color;
	
	public Product getProduct() {
		return product = ProductDAO.getInstance().GetProductByID(pID);
	}
	
	public Color getColor() {
		return color = ColorDAO.getInstance().GetColorByID(cID);
	}
	
	public String getpID() {
		return pID;
	}

	public void setpID(String pID) {
		this.pID = pID;
	}

	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
	}

	public int getKeyID() {
		return keyID;
	}

	public void setKeyID(int keyID) {
		this.keyID = keyID;
	}
	
	public byte[] getImage() {
		return image;
	}
	
	public String getBase64() {
		return base64;
	}

	public ProductImage(String pID, int cID, int keyID, byte[] image) {
		super();
		this.pID = pID;
		this.cID = cID;
		this.keyID = keyID;
		this.base64 = Base64.encode(image);
	}
}
