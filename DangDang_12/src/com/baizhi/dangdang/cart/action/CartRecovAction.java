package com.baizhi.dangdang.cart.action;

import com.baizhi.dangdang.cart.service.CartService;
import com.baizhi.dangdang.cart.serviceImpl.CartServiceImpl;
import com.opensymphony.xwork2.Action;

public class CartRecovAction implements Action{
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String execute() throws Exception {
		CartService service = new CartServiceImpl();
		service.cartRecov(id);
		return SUCCESS;
	}

}
