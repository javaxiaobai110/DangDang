package com.baizhi.dangdang.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class CheckCodeAction implements Action{
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ValueStack vs = ActionContext.getContext().getValueStack();
		String val = (String) vs.findValue("#application.code");
		System.out.println(code+"++++++");
		System.out.println(val+"------");
		if(val.equalsIgnoreCase(code)){
			out.println("ok");
			return null;
		}else{
			out.println("验证码错误");
			return null;
		}
		
	}
	
	

}
