package com.baizhi.dangdang.cart.action;

import com.baizhi.dangdang.cart.service.CartService;
import com.baizhi.dangdang.cart.serviceImpl.CartServiceImpl;
import com.opensymphony.xwork2.Action;

public class CartUpdateAction implements Action{
	private String id;
	private Integer count;
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(id+"hhhhhhhhh"+count);
		CartService service = new CartServiceImpl();
		service.cartUpdate(id, count);
		return SUCCESS;
	}

}
