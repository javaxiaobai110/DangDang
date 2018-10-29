package com.baizhi.dangdang.address.serviceImpl;

import java.util.List;

import com.baizhi.dangdang.address.dao.AddressDao;
import com.baizhi.dangdang.address.service.AddressService;
import com.baizhi.dangdang.entity.Address;
import com.baizhi.dangdang.util.MybatisUtil;

public class AddressServiceImpl implements AddressService{

	@Override
	public List<Address> getAddressByDuserId(String id) {
		try{
			AddressDao dao = (AddressDao) MybatisUtil.getDao(AddressDao.class);
			List<Address> list = dao.queryAddressByDuserId(id);
			MybatisUtil.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("查询地址失败");
		}
		
	}

	@Override
	public Address getAddressById(String id) {
		try{
			AddressDao dao = (AddressDao) MybatisUtil.getDao(AddressDao.class);
			Address address = dao.queryAddressById(id);
			MybatisUtil.commit();
			return address;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("查询地址失败");
		}
	}

	@Override
	public void addAddress(Address address) {
		try{
			AddressDao dao = (AddressDao) MybatisUtil.getDao(AddressDao.class);
			dao.insert(address);
			MybatisUtil.commit();
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("更新失败");
		}
	}

	@Override
	public void updateAddress(Address address) {
		try{
			AddressDao dao = (AddressDao) MybatisUtil.getDao(AddressDao.class);
			dao.update(address);
			MybatisUtil.commit();
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("更新失败");
		}
	}
}
