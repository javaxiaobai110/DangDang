package com.baizhi.dangdang.entity;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable{
	private String id;
	private String categoryName;
	private String parentId;
	private List<Category> list;
	public Category() {
		super();
	}
	public Category(String id, String categoryName, String parentId,
			List<Category> list) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.parentId = parentId;
		this.list = list;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public List<Category> getList() {
		return list;
	}
	public void setList(List<Category> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName
				+ ", parentId=" + parentId + ", list=" + list + "]";
	}
	
	
	
	
}
