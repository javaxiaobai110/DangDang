package com.baizhi.dangdang.product.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.baizhi.dangdang.entity.Category;
import com.baizhi.dangdang.entity.Dbook;
import com.baizhi.dangdang.product.dao.ProductDao;
import com.baizhi.dangdang.product.service.ProductService;
import com.baizhi.dangdang.util.MybatisUtil;

public class ProductServiceImpl implements ProductService{

	@Override
	public List<Dbook> getByRecommend() {
		try{
			ProductDao dao = (ProductDao) MybatisUtil.getDao(ProductDao.class);
			List<Dbook> list = dao.queryByRecommend();
			MybatisUtil.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("查询失败");
		}
	}

	@Override
	public List<Dbook> getBySalnum() {
		try{
			ProductDao dao = (ProductDao) MybatisUtil.getDao(ProductDao.class);
			List<Dbook> list = dao.queryProductBySalnum();
			MybatisUtil.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("查询失败");
		}
	}

	@Override
	public List<Dbook> getByCreateTime() {
		try{
			ProductDao dao = (ProductDao) MybatisUtil.getDao(ProductDao.class);
			List<Dbook> list = dao.queryByCreateDate();
			MybatisUtil.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("查询失败");
		}
	}

	@Override
	public List<Dbook> getByCreateTimeAndSalnum() {
		try{
			ProductDao dao = (ProductDao) MybatisUtil.getDao(ProductDao.class);
			List<Dbook> list = dao.queryByCreateDateAndSalnum();
			MybatisUtil.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("查询失败");
		}
	}

	@Override
	public List<Dbook> getByCatId(String sc, String ssc, RowBounds rb) {
		try{
			ProductDao dao = (ProductDao) MybatisUtil.getDao(ProductDao.class);
			List<Dbook> list = dao.queryByCatId(sc, ssc,rb);
			MybatisUtil.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("查询失败");
		}
	}

	@Override
	public List<Dbook> getAllByCatId(String sc, String ssc) {
		try{
			ProductDao dao = (ProductDao) MybatisUtil.getDao(ProductDao.class);
			List<Dbook> list = dao.queryAllByCatId(sc, ssc);
			MybatisUtil.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("查询失败");
		}
	}

	@Override
	public Dbook getById(String id) {
		try{
			ProductDao dao = (ProductDao) MybatisUtil.getDao(ProductDao.class);
			Dbook dbook = dao.queryById(id);
			MybatisUtil.commit();
			return dbook;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("查询失败");
		}
	}
}
