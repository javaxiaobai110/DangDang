package com.baizhi.dangdang.entity;

import java.io.Serializable;

public class Order implements Serializable{
	private String id;
	private Double totalPrice;
	private Duser duser;
	private Address address;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String id, Double totalPrice, Duser duser, Address address) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.duser = duser;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Duser getDuser() {
		return duser;
	}
	public void setDuser(Duser duser) {
		this.duser = duser;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", totalPrice=" + totalPrice + ", duser="
				+ duser + ", address=" + address + "]";
	}
	
}
