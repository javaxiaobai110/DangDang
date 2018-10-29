package com.baizhi.dangdang.user.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.config.entities.ActionConfig;

public class SafeExitAction implements Action{

	@Override
	public String execute() throws Exception {
		
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		session.invalidate();
		
		return "success";
	}

}
