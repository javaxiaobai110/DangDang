package com.baizhi.dangdang.product.action;

import java.util.List;

import com.baizhi.dangdang.entity.Dbook;
import com.baizhi.dangdang.product.service.ProductService;
import com.baizhi.dangdang.product.serviceImpl.ProductServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class ShowProductByRecommendAction implements Action{

	@Override
	public String execute() throws Exception {
		ProductService service = new ProductServiceImpl();
		List<Dbook> list = service.getByRecommend();
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.setValue("#request.plist", list);
		return "success";
	}

}
