package com.baizhi.dangdang.order.serviceImpl;

import com.baizhi.dangdang.entity.Order;
import com.baizhi.dangdang.order.dao.OrderDao;
import com.baizhi.dangdang.order.service.OrderService;
import com.baizhi.dangdang.util.MybatisUtil;

public class OrderServiceImpl implements OrderService{

	@Override
	public void addOrder(Order order) {
		try{
			OrderDao dao = (OrderDao) MybatisUtil.getDao(OrderDao.class);
			dao.insert(order);
			MybatisUtil.commit();
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("添加失败");
		}
	}
}
