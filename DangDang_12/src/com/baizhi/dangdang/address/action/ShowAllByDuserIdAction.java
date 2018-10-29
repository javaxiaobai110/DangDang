package com.baizhi.dangdang.address.action;

import java.io.PrintWriter;
import java.util.List;

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

public class ShowAllByDuserIdAction implements Action {
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String execute() throws Exception {
		//ValueStack vs = ActionContext.getContext().getValueStack();
		//vs.setValue("#session.isOk", "ok");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		AddressService service = new AddressServiceImpl();
		List<Address> list = service.getAddressByDuserId(id);
		GsonBuilder gb = new GsonBuilder();
		Gson gson = gb.create();
		String json = gson.toJson(list);
		out.println(json);
		return null;
	}
}
