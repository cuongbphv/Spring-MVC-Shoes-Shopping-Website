package com.mvp.model;

import java.util.*;

import com.mvp.DAO.ProductDAO;

 
public class ShoppingCart {
  private ArrayList itemsOrdered;
  private int discount;
  private String discountCode;
  
  public String getDiscountCode() {
	return discountCode;
}

public void setDiscountCode(String discountCode) {
	this.discountCode = discountCode;
}

public ShoppingCart() {
    itemsOrdered = new ArrayList();
    discount  = 0 ;
    discountCode = null;
  }
  
 public int getDiscount() {
	return discount;
}

public void setDiscount(int discount) {
	this.discount = discount;
}

public List getItemsOrdered() {
    return(itemsOrdered);
  }
  
  public synchronized void addItem(String itemID, int colorID, int sizeID) {
    ItemOrder order;
    for(int i=0; i<itemsOrdered.size(); i++) {
      order = (ItemOrder)itemsOrdered.get(i);
      if (order.getItemID().equals(itemID) && order.getSizeID()== sizeID && order.getColorID() == colorID) {
        order.incrementNumItems();
        return;
      }
    }
    ItemOrder newOrder = new ItemOrder(ProductDAO.getInstance().GetProductByID(itemID),ProductDAO.getInstance().GetColorById(colorID),
    		ProductDAO.getInstance().GetSizeById(sizeID));
    itemsOrdered.add(newOrder);
  }

  
  public synchronized void setNumOrdered(String itemID,int colorID, int sizeID, int numOrdered) {
    ItemOrder order;
    for(int i=0; i<itemsOrdered.size(); i++) {
      order = (ItemOrder)itemsOrdered.get(i);
      if (order.getItemID().equals(itemID) && order.getSizeID()== sizeID && order.getColorID() == colorID) {
        if (numOrdered <= 0) {
          itemsOrdered.remove(i);
        } else {
          order.setNumItems(numOrdered);
        }
        return;
      }
    }
    ItemOrder newOrder = new ItemOrder(ProductDAO.getInstance().GetProductByID(itemID),ProductDAO.getInstance().GetColorById(colorID),
    		ProductDAO.getInstance().GetSizeById(sizeID));
    itemsOrdered.add(newOrder);
  }
  
  
  public String getTotalPrice() {
	  double num = 0;
	  for(int i = 0 ; i < itemsOrdered.size(); i++)
	  {
		  ItemOrder item= (ItemOrder)itemsOrdered.get(i);
		  num += Double.parseDouble(item.getItem().getDiscountPrice()) * item.getNumItems();
	  }
	  return num+"";
  }
  
  public int getCurrentStock (String itemID, int colorID, int sizeID) {
	  for(int i = 0; i <itemsOrdered.size() ; i++ )
	  {
		  ItemOrder item= (ItemOrder)itemsOrdered.get(i);
		  if(item.getItemID().equals(itemID) && item.getSizeID()== sizeID && item.getColorID() == colorID)
			  return item.getNumItems();
	  }
	  return 0;
  }
  
}
    
