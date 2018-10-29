package com.baizhi.dangdang.category.action;

import java.util.List;

import com.baizhi.dangdang.category.service.CategoryService;
import com.baizhi.dangdang.category.serviceImpl.CategoryServiceImpl;
import com.baizhi.dangdang.entity.Category;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class ShowAllAction implements Action{

	public String execute() throws Exception {
		CategoryService service = new CategoryServiceImpl();
		List<Category> list = service.getAll();
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.setValue("#request.list", list);
		return "success";
	}

}
