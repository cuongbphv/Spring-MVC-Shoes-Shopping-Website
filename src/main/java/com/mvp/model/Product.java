package com.mvp.model;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.util.List;

import com.mvp.DAO.*;

public class Product {

	private String iD;
	private String name;
	private int quantity;
	private int producerID;
	private int materialID;
	private String price;
	private int discount;
	private byte[] image;
	private int typeID;
	private String description;
	private String base64; 
	private Producer producer;
	private Material material;
	private ProductType productType;
	private List<Color> colorList;
	private List<ShoeSize> sizeList; 

	

	public List<Color> getColorList() {
		this.colorList = ProductDAO.getInstance().GetColorListByPID(this.iD);
		return colorList;
	}

	public List<ShoeSize> getSizeList() {
		this.sizeList = ProductDAO.getInstance().GetSizeListByPID(this.iD);
		return sizeList;
	}

	public Producer getProducer() {
		return producer = ProductDAO.getInstance().GetProducerByPID(iD);
	}

	public Material getMaterial() {
		return material = ProductDAO.getInstance().GetMaterialByPID(iD);
	}

	public ProductType getProductType() {
		return productType = ProductDAO.getInstance().GetProductTypeByPID(iD);
	}

	public String getBase64() {
	    return base64;
	}
		
	public Product() {
		
	}


	public Product(String iD, String name, int quantity, int producerID, int materialID, String price, int discount,
			byte[] image, int typeID, String description) {
		super();
		this.iD = iD;
		this.name = name;
		this.quantity = quantity;
		this.producerID = producerID;
		this.materialID = materialID;
		this.price = price;
		this.discount = discount;
		this.image = image;
		this.typeID = typeID;
		this.description = description;
		this.base64 = Base64.encode(image);
	}


	public String getiD() {
		return iD;
	}


	public String getName() {
		return name;
	}


	public int getQuantity() {
		return quantity;
	}


	public int getProducerID() {
		return producerID;
	}


	public int getMaterialID() {
		return materialID;
	}


	public String getPrice() {
		return price;
	}


	public int getDiscount() {
		return discount;
	}


	public byte[] getImage() {
		return image;
	}


	public int getTypeID() {
		return typeID;
	}


	public String getDescription() {
		return description;
	}


	public void setiD(String iD) {
		this.iD = iD;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public void setProducerID(int producerID) {
		this.producerID = producerID;
	}


	public void setMaterialID(int materialID) {
		this.materialID = materialID;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getDiscountPrice() {
		double discount = Double.parseDouble(price) - Double.parseDouble(price)*this.discount/100;
		return discount+"";
	}	
	
}
