package com.baizhi.dangdang.entity;

import java.io.Serializable;

public class CartItem implements Serializable{
	private Dbook dbook;
	private Integer count;
	private Double price;//市场价小计
	private Double ddPrice;//当当价小计
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(Dbook dbook, Integer count, Double price, Double ddPrice) {
		super();
		this.dbook = dbook;
		this.count = count;
		this.price = price;
		this.ddPrice = ddPrice;
	}
	public Dbook getDbook() {
		return dbook;
	}
	public void setDbook(Dbook dbook) {
		this.dbook = dbook;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDdPrice() {
		return ddPrice;
	}
	public void setDdPrice(Double ddPrice) {
		this.ddPrice = ddPrice;
	}
	@Override
	public String toString() {
		return "CartItem [dbook=" + dbook + ", count=" + count + ", price="
				+ price + ", ddPrice=" + ddPrice + "]";
	}
	
}
