package com.baizhi.dangdang.product.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.baizhi.dangdang.entity.Category;
import com.baizhi.dangdang.entity.Dbook;

public interface ProductDao {
	public List<Dbook> queryByRecommend();
	public List<Dbook> queryProductBySalnum();
	public List<Dbook> queryByCreateDate();
	public List<Dbook> queryByCreateDateAndSalnum();
	public List<Dbook> queryByCatId(@Param("sc")String sc,@Param("ssc")String ssc, @Param("rb")RowBounds rb);
	public List<Dbook> queryAllByCatId(@Param("sc")String sc, @Param("ssc")String ssc);
	public Dbook queryById(String id);
	
}
