package com.baizhi.dangdang.user.dao;

import org.apache.ibatis.annotations.Param;

import com.baizhi.dangdang.entity.Duser;

public interface DuserDao {
	public void insertDuser(Duser duser);
	public Duser queryOneDuser(String email);
	public Duser queryOneDuserByEmailAndPassword(@Param("email")String email, @Param("password")String password);
	public void activeDuser(@Param("activeCode")Integer activeCode, @Param("id")String id);
	public Duser queryOndeDuserById(String id);
}
