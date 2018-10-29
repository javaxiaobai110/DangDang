package com.baizhi.dangdang.orderItem.serviceImpl;

import java.util.List;

import com.baizhi.dangdang.entity.OrderItem;
import com.baizhi.dangdang.orderItem.dao.OrderItemDao;
import com.baizhi.dangdang.orderItem.service.OrderItemService;
import com.baizhi.dangdang.util.MybatisUtil;

public class OrderItemServiceImpl implements OrderItemService{

	@Override
	public void addOrderItem(List<OrderItem> list) {
		try{
			OrderItemDao dao = (OrderItemDao) MybatisUtil.getDao(OrderItemDao.class);
			dao.insertOrderItem(list);
			MybatisUtil.commit();
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("插入失败");
		}
		
	}
	

}
