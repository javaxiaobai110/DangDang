package com.baizhi.dangdang.product.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.baizhi.dangdang.entity.Category;
import com.baizhi.dangdang.entity.Dbook;

public interface ProductService {
	//1, getByreCommend
	public List<Dbook> getByRecommend();
	
	//2, getBySalnum
	public List<Dbook> getBySalnum();
	
	//3, getByCreateTime
	public List<Dbook> getByCreateTime();
	
	//4, getByCreateTimeAndSalnum
	public List<Dbook> getByCreateTimeAndSalnum();

	//5, getByCatId
	public List<Dbook> getByCatId(String sc,String ssc, RowBounds rb);

	//6, getAllCount
	public List<Dbook> getAllByCatId(String sc, String ssc);

	//7, getById
	public Dbook getById(String id);
}
