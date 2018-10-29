package com.baizhi.dangdang.product.action;

import com.baizhi.dangdang.entity.Dbook;
import com.baizhi.dangdang.product.service.ProductService;
import com.baizhi.dangdang.product.serviceImpl.ProductServiceImpl;
import com.opensymphony.xwork2.Action;

public class ShowProductById implements Action{
	private String id;
	private Dbook dbook;
	public Dbook getDbook() {
		return dbook;
	}
	public void setDbook(Dbook dbook) {
		this.dbook = dbook;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String execute() throws Exception {
		ProductService service = new ProductServiceImpl();
		dbook = service.getById(id);
		return SUCCESS;
	}
	

}
