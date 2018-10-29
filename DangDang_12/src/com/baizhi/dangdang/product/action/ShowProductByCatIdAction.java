package com.baizhi.dangdang.product.action;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.baizhi.dangdang.category.service.CategoryService;
import com.baizhi.dangdang.category.serviceImpl.CategoryServiceImpl;
import com.baizhi.dangdang.entity.Category;
import com.baizhi.dangdang.entity.Dbook;
import com.baizhi.dangdang.product.service.ProductService;
import com.baizhi.dangdang.product.serviceImpl.ProductServiceImpl;
import com.baizhi.dangdang.util.PageBean;
import com.opensymphony.xwork2.Action;

public class ShowProductByCatIdAction implements Action{
	private String sc;
	private String ssc;
	private Category category;
	private List<Dbook> list;
	private int allCount;//商品的数量
	private int sipCount;
	private int pageNo;
	
	
	
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getSipCount() {
		return sipCount;
	}
	public void setSipCount(int sipCount) {
		this.sipCount = sipCount;
	}
	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	public List<Dbook> getList() {
		return list;
	}
	public void setList(List<Dbook> list) {
		this.list = list;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getSc() {
		return sc;
	}
	public void setSc(String sc) {
		this.sc = sc;
	}
	public String getSsc() {
		return ssc;
	}
	public void setSsc(String ssc) {
		this.ssc = ssc;
	}
	@Override
	public String execute() throws Exception {
		if(ssc==null || ssc.equals("")){
			ssc=null;
		}
		
		PageBean pb = new PageBean();
		pb.setPageNo(pageNo);
		RowBounds rb = new RowBounds((pb.getPageNo()-1)*pb.getPageRow(),pb.getPageRow());
		CategoryService cservice = new CategoryServiceImpl();
		category = cservice.getByCategoryId(sc);
		ProductService pservice = new ProductServiceImpl();
		list = pservice.getAllByCatId(sc, ssc);
		
		if(list.size() % pb.getPageRow() != 0){
			allCount = list.size() / pb.getPageRow() + 1;
		}else{
			allCount = list.size() / pb.getPageRow();
		}
		list = pservice.getByCatId(sc, ssc,rb);
		
		return SUCCESS;
	}

}
