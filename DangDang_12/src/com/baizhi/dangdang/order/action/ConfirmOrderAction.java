package com.baizhi.dangdang.order.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class ConfirmOrderAction implements Action{

	@Override
	public String execute() throws Exception {
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.setValue("#session.isOk", "ok");
		return "success";
	}

}
