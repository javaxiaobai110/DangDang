package com.baizhi.dangdang.util;

public class PageBean {
	private int pageNo = 1;//页码
	private int pageRow = 3;//每页行数
	private int totalRow ; //总行数
	public int getBegin(){//起始行号
		return (pageNo-1)*3+1;
		
	}
	public int getEnd(){//结束行号
		return pageNo*pageRow;
	}
	public int getTotalPage(){//总页码
		int num = totalRow / pageRow;
		if(totalRow % pageRow != 0)num++;
		return num;
	}
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean(int pageNo, int pageRow, int totalRow) {
		super();
		this.pageNo = pageNo;
		this.pageRow = pageRow;
		this.totalRow = totalRow;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageRow() {
		return pageRow;
	}
	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}
	public int getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
	@Override
	public String toString() {
		return "PageBean [pageNo=" + pageNo + ", pageRow=" + pageRow
				+ ", totalRow=" + totalRow + "]";
	}
	
	
}
