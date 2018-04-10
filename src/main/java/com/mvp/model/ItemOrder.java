package com.mvp.model;

public class ItemOrder {

	private Product item;
	private Color colorItem;
	private ShoeSize sizeItem;
	private int numItems;

	public ItemOrder() {
		
	}


	public ItemOrder(Product item, Color colorItem, ShoeSize sizeItem) {
		super();
		this.item = item;
		this.colorItem = colorItem;
		this.sizeItem = sizeItem;
		this.numItems = 1;
	}
	
	public int getNumItems() {
		return numItems;
	}


	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}
	
	
	public Product getItem() {
		return item;
	}
	public Color getColorItem() {
		return colorItem;
	}
	public ShoeSize getSizeItem() {
		return sizeItem;
	}
	public void setItem(Product item) {
		this.item = item;
	}
	public void setColorItem(Color colorItem) {
		this.colorItem = colorItem;
	}
	public void setSizeItem(ShoeSize sizeItem) {
		this.sizeItem = sizeItem;
	}
	
	
	public String getItemID() {
		return item.getiD();
	}
	
	public int getColorID() {
		return colorItem.getiD();
	}
	
	
	public int getSizeID() {
		return sizeItem.getiD();
	}
	
	
	
	public void incrementNumItems() {
		setNumItems(this.getNumItems() + 1);
	}
	
	public void cancelOrder() {
		setNumItems(0);
	}

	
}
