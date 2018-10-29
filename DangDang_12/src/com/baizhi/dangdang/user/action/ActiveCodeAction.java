package com.baizhi.dangdang.user.action;

import com.baizhi.dangdang.entity.Duser;
import com.baizhi.dangdang.user.service.DuserService;
import com.baizhi.dangdang.user.serviceImpl.DuserServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class ActiveCodeAction implements Action{
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String execute() throws Exception {
		ValueStack vs = ActionContext.getContext().getValueStack();
		String did = (String) vs.findValue("#session.duserId");
		DuserService service = new DuserServiceImpl();
		Duser duser = service.findOneDuserById(did);
		vs.setValue("#session.activeEmail", duser.getEmail());
		int activeCode = 1;
		service.activeDuser(activeCode,id);
		return SUCCESS;
	}

}
