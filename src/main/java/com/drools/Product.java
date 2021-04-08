package com.drools;

public class Product {
	
	String productName;
	double productPrice;
	double discount;
	
	public Product(String productName, double productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public Product() {
		
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	

}
