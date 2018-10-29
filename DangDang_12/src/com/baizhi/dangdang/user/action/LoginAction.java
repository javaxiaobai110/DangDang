package com.baizhi.dangdang.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dangdang.entity.Duser;
import com.baizhi.dangdang.user.service.DuserService;
import com.baizhi.dangdang.user.serviceImpl.DuserServiceImpl;
import com.baizhi.dangdang.util.Md5Util;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class LoginAction implements Action{
	private Duser duser;
	
	public Duser getDuser() {
		return duser;
	}
	public void setDuser(Duser duser) {
		this.duser = duser;
	}
	@Override
	public String execute() throws Exception {
		
		ValueStack vs = ActionContext.getContext().getValueStack();
		DuserService service = new DuserServiceImpl();
		Duser user = service.findOneDuser(duser.getEmail());
		if(user == null){
			vs.setValue("#request.msg", "email不存在,请注册");
			return ERROR;
		}
		boolean flag = Md5Util.checkPassword(duser.getPassword()+user.getSalt(), user.getPassword());
		if(flag == true)
			duser = user;
		else
			duser = null;
		if(duser==null){
			vs.setValue("#request.msg", "email地址或密码错误");
			
			return ERROR;
		}else if(duser.getStatus() == 0){
			vs.setValue("#session.duserId", duser.getId());
			vs.setValue("#request.loginfo", "账户未激活,点击激活");
			
			vs.setValue("#session.activeEmail", duser.getEmail());
			vs.setValue("#session.activeNickName", duser.getNickName());
			return ERROR;
		}else{
			vs.setValue("#session.loginfo", duser.getNickName());
			vs.setValue("#session.duserId", duser.getId());
			String msg = (String) vs.findValue("#session.isOk");
			if(msg!=null){
				return "addressAction";
			}else{
				return SUCCESS;
			}
		}
	}

}
