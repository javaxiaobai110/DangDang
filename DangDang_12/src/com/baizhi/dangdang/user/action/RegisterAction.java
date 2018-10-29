package com.baizhi.dangdang.user.action;

import java.util.UUID;

import com.baizhi.dangdang.entity.Duser;
import com.baizhi.dangdang.user.service.DuserService;
import com.baizhi.dangdang.user.serviceImpl.DuserServiceImpl;
import com.baizhi.dangdang.util.Md5Util;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;


public class RegisterAction implements Action{
	private Duser duser;
	public Duser getDuser() {
		return duser;
	}
	public void setDuser(Duser duser) {
		this.duser = duser;
	}
	@Override
	public String execute() throws Exception {
		String salt = Md5Util.getSalt();
		String uuid = UUID.randomUUID().toString();
		DuserService service = new DuserServiceImpl();
		duser.setId(uuid);
		duser.setSalt(salt);
		String encryption = Md5Util.encryption(duser.getPassword()+duser.getSalt());
		duser.setPassword(encryption);
		service.register(duser);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.setValue("#session.activeEmail", duser.getEmail());
		vs.setValue("#session.duserId", duser.getId());
		vs.setValue("#session.registerName", duser.getNickName());
		
		return SUCCESS;
		
	}

}
