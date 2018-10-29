package com.baizhi.dangdang.address.dao;

import java.util.List;

import com.baizhi.dangdang.entity.Address;

public interface AddressDao {
	public List<Address> queryAddressByDuserId(String id);
	public Address queryAddressById(String id);
	public void insert(Address address);
	public void update(Address address);
}
