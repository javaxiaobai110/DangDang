package com.baizhi.dangdang.cart.service;

public interface CartService {
	public void cartAdd(String id);
	public void cartUpdate(String id, Integer count);
	public void cartRecov(String id);
}
