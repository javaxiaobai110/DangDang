package com.baizhi.dangdang.address.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dangdang.address.service.AddressService;
import com.baizhi.dangdang.address.serviceImpl.AddressServiceImpl;
import com.baizhi.dangdang.entity.Address;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class ShowOneByIdAction implements Action{
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		/*ValueStack vs = ActionContext.getContext().getValueStack();
		String msg = (String) vs.findValue("#session.loginfo");
		if(msg==null){
			vs.setValue("#session.isOk", "ok");
			return "error";
		}*/
		PrintWriter out = response.getWriter();
		AddressService service = new AddressServiceImpl();
		Address address = service.getAddressById(id);
		Gson gson = new Gson();
		String json = gson.toJson(address);
		out.println(json);
		return null;
	}

}
