package com.ims.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class SalesModel
{
	private int id;
	private String purchasedBy;
	private String soldBy;
	private String productName;
	private int quantity;
	private float price;
	private String totalPrice;
	public String getTotalPrice()
	{
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice)
	{
		this.totalPrice = totalPrice;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getPurchasedBy()
	{
		return purchasedBy;
	}
	public void setPurchasedBy(String purchasedBy)
	{
		this.purchasedBy = purchasedBy;
	}
	public String getSoldBy()
	{
		return soldBy;
	}
	public void setSoldBy(String soldBy)
	{
		this.soldBy = soldBy;
	}
	public String getProductName()
	{
		return productName;
	}
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public float getPrice()
	{
		return price;
	}
	public void setPrice(float price)
	{
		this.price = price;
	}
}
