package com.cdac.training.bean;

public class Product {
	private int prodId;
	private String prodName;
	private String prodType;
	private double prodPrice;
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public double getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int prodId, String prodName, String prodType, double prodPrice) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodType = prodType;
		this.prodPrice = prodPrice;
	}
	@Override
	public String toString() {
		return "\nprodId=" + prodId + ", prodName=" + prodName + ", prodType=" + prodType + ", prodPrice="
				+ prodPrice;
	}
}
