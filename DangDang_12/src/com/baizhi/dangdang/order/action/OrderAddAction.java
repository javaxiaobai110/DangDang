package com.baizhi.dangdang.order.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.baizhi.dangdang.address.service.AddressService;
import com.baizhi.dangdang.address.serviceImpl.AddressServiceImpl;
import com.baizhi.dangdang.entity.Address;
import com.baizhi.dangdang.entity.CartItem;
import com.baizhi.dangdang.entity.Duser;
import com.baizhi.dangdang.entity.Order;
import com.baizhi.dangdang.entity.OrderItem;
import com.baizhi.dangdang.order.service.OrderService;
import com.baizhi.dangdang.order.serviceImpl.OrderServiceImpl;
import com.baizhi.dangdang.orderItem.service.OrderItemService;
import com.baizhi.dangdang.orderItem.serviceImpl.OrderItemServiceImpl;
import com.baizhi.dangdang.user.service.DuserService;
import com.baizhi.dangdang.user.serviceImpl.DuserServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class OrderAddAction implements Action{
	private Address address;
	private String duserId;
	public String getDuserId() {
		return duserId;
	}
	public void setDuserId(String duserId) {
		this.duserId = duserId;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(address);
		ValueStack vs = ActionContext.getContext().getValueStack();
		DuserService dservice = new DuserServiceImpl();
		Duser duser = dservice.findOneDuserById(duserId);
		Double totalProductDdPrice = (Double) vs.findValue("#session.totalProductDdPrice");
		AddressService service = new AddressServiceImpl();
		Address addr = service.getAddressById(address.getId());
		if(addr == null){
			addr = new Address(UUID.randomUUID().toString(),address.getReciveName(),address.getDetailAddress(),address.getTelNumber(),address.getPhoneNumber(), duser,address.getZipcode());
			service.addAddress(addr);
		}else{
			service.updateAddress(address);
		}
		
		Order order = new Order(UUID.randomUUID().toString(),totalProductDdPrice,duser,addr);
		OrderService oservice = new OrderServiceImpl();
		oservice.addOrder(order);
		Map<String, CartItem> map = (Map<String, CartItem>) vs.findValue("#session.map");
		List<OrderItem> list = new ArrayList<OrderItem>();
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			String next = iterator.next();
			CartItem cartItem = map.get(next);
			list.add(new OrderItem(UUID.randomUUID().toString(),cartItem.getDbook(),cartItem.getCount(),cartItem.getDdPrice(),order));
		}
		
		for(OrderItem ci : list){
			System.out.println(ci);
		}
		System.out.println(list.size());
		OrderItemService oiservice = new OrderItemServiceImpl();
		oiservice.addOrderItem(list);
		vs.setValue("#session.ordid", order.getId());
		vs.setValue("#session.map", null);
		return SUCCESS;
	}

}
