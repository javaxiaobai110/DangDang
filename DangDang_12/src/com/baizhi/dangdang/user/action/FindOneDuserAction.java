package com.baizhi.dangdang.user.action;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dangdang.entity.Duser;
import com.baizhi.dangdang.user.service.DuserService;
import com.baizhi.dangdang.user.serviceImpl.DuserServiceImpl;
import com.opensymphony.xwork2.Action;


public class FindOneDuserAction implements Action{
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println(email+"------");
		DuserService service = new DuserServiceImpl();
		Duser duser = service.findOneDuser(email);
		if(duser == null){
			out.println("ok");
		}else{
			out.println("该邮箱已被注册");
		}
		return null;
	}

}
