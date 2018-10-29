package com.baizhi.dangdang.user.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;




import com.baizhi.dangdang.util.CreateValidateCode;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.config.entities.ActionConfig;
import com.opensymphony.xwork2.util.ValueStack;

public class ImageAction implements Action{

	@Override
	public String execute() throws Exception {
		// 画一张随机图片 --- 使用工具类的write方法画图片
		CreateValidateCode cvc = new CreateValidateCode();
		//获取图片上的随机数  --- 存档  --- session
		String code = cvc.getCode();
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.setValue("#application.code", code);
		System.out.println(code);
		//在输出图片
		cvc.write( ServletActionContext.getResponse().getOutputStream());
		System.out.println("hehe");
		return null;
	}

}
