package com.baizhi.dangdang.user.serviceImpl;

import com.baizhi.dangdang.entity.Duser;
import com.baizhi.dangdang.excp.FindFailException;
import com.baizhi.dangdang.excp.RegisterFailException;
import com.baizhi.dangdang.user.dao.DuserDao;
import com.baizhi.dangdang.user.service.DuserService;
import com.baizhi.dangdang.util.MybatisUtil;


public class DuserServiceImpl implements DuserService{

	@Override
	public void register(Duser duser) {
		try{
			DuserDao dao = (DuserDao) MybatisUtil.getDao(DuserDao.class);
			dao.insertDuser(duser);
			MybatisUtil.commit();
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RegisterFailException("注册失败");
		}
		
		
	}

	@Override
	public Duser findOneDuser(String email) {
		try{
			DuserDao dao = (DuserDao) MybatisUtil.getDao(DuserDao.class);
			Duser duser = dao.queryOneDuser(email);
			MybatisUtil.commit();
			return duser;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new FindFailException("查询失败");
		}
	}

	@Override
	public Duser findOneDuser(String email, String password) {
		try{
			DuserDao dao = (DuserDao) MybatisUtil.getDao(DuserDao.class);
			Duser duser = dao.queryOneDuserByEmailAndPassword(email, password);
			MybatisUtil.commit();
			return duser;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("登陆失败");
		}
	}

	@Override
	public void activeDuser(Integer activeCode, String id) {
		try{
			DuserDao dao = (DuserDao) MybatisUtil.getDao(DuserDao.class);
			dao.activeDuser(activeCode,id);
			MybatisUtil.commit();
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("激活失败");
		}
		
		
	}

	@Override
	public Duser findOneDuserById(String id) {
		try{
			DuserDao dao = (DuserDao) MybatisUtil.getDao(DuserDao.class);
			Duser duser = dao.queryOndeDuserById(id);
			MybatisUtil.commit();
			return duser;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException();
		}
	}
}
