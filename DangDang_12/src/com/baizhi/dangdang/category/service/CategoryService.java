package com.baizhi.dangdang.category.service;

import java.util.List;

import com.baizhi.dangdang.entity.Category;

public interface CategoryService {
	//1,getAll
	public List<Category> getAll();

	//2,
	public Category getByCategoryId(String categoryId);
}
