package com.baizhi.dangdang.entity;

import java.io.Serializable;

public class OrderItem implements Serializable{
	private String id;
	private Dbook dbook;
	private Integer count;
	private Double price;
	private Order order;
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItem(String id, Dbook dbook, Integer count, Double price,
			Order order) {
		super();
		this.id = id;
		this.dbook = dbook;
		this.count = count;
		this.price = price;
		this.order = order;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", dbook=" + dbook + ", count=" + count
				+ ", price=" + price + ", order=" + order + "]";
	}
	
}
