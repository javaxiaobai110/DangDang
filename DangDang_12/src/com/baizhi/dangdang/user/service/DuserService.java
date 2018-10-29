package com.baizhi.dangdang.user.service;

import com.baizhi.dangdang.entity.Duser;

public interface DuserService {
	//1, register
	public void register(Duser duser);
	
	//2, find one by email
	public Duser findOneDuser(String email);
	
	//3, find one by email and password
	public Duser findOneDuser(String email, String password);
	
	//4, active duser
	public void activeDuser(Integer activeCode,String id);
	
	//5, find one by id
	public Duser findOneDuserById(String id);
}
