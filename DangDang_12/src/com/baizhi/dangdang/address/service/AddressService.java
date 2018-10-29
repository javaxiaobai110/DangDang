package com.baizhi.dangdang.address.service;

import java.util.List;

import com.baizhi.dangdang.entity.Address;

public interface AddressService {
	//1,get address by duserid
	public List<Address> getAddressByDuserId(String id);
	
	//2, get one address by id
	public Address getAddressById(String id);

	//3, add address
	public void addAddress(Address address);
	
	//4, update address
	public void updateAddress(Address address);
}
