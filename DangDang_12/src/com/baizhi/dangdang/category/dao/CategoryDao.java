package com.baizhi.dangdang.category.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.baizhi.dangdang.entity.Category;

public interface CategoryDao {
	public List<Category> queryAll();
	public Category queryByCategoryId(@Param("pid")String categoryId);

}
