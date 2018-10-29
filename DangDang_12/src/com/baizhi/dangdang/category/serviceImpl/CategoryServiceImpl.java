package com.baizhi.dangdang.category.serviceImpl;

import java.util.List;

import com.baizhi.dangdang.category.dao.CategoryDao;
import com.baizhi.dangdang.category.service.CategoryService;
import com.baizhi.dangdang.entity.Category;
import com.baizhi.dangdang.product.dao.ProductDao;
import com.baizhi.dangdang.util.MybatisUtil;

public class CategoryServiceImpl implements CategoryService{

	@Override
	public List<Category> getAll() {
		try{
			CategoryDao dao = (CategoryDao) MybatisUtil.getDao(CategoryDao.class);
			List<Category> list = dao.queryAll();
			MybatisUtil.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("查询失败");
		}
	}
	
	@Override
	public Category getByCategoryId(String categoryId) {
		try{
			CategoryDao dao = (CategoryDao) MybatisUtil.getDao(CategoryDao.class);
			Category cat = dao.queryByCategoryId(categoryId);
			MybatisUtil.commit();
			return cat;
		}catch(Exception e){
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException("查询失败");
		}
	}

}
