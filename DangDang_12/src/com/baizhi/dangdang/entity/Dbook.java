package com.baizhi.dangdang.entity;

import java.io.Serializable;
import java.util.Date;

public class Dbook implements Serializable{
	private String id;
	private String author;
	private Date createdate;
	private String company;
	private String edition;
	private Date printtime;
	private String print;
	private String isbn;
	private Integer wordcount;
	private Integer pagecount;
	private String format;
	private String paper;
	private String packaeg;
	private String src;
	private Integer count;
	private Integer salecount;
	private Integer recommend;
	private Category category;
	private Double price;
	private Double ddprice;
	private String bookname;
	public Dbook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dbook(String id, String author, Date createdate, String company,
			String edition, Date printtime, String print, String isbn,
			Integer wordcount, Integer pagecount, String format, String paper,
			String packaeg, String src, Integer count, Integer salecount,
			Integer recommend, Category category, Double price, Double ddprice,
			String bookname) {
		super();
		this.id = id;
		this.author = author;
		this.createdate = createdate;
		this.company = company;
		this.edition = edition;
		this.printtime = printtime;
		this.print = print;
		this.isbn = isbn;
		this.wordcount = wordcount;
		this.pagecount = pagecount;
		this.format = format;
		this.paper = paper;
		this.packaeg = packaeg;
		this.src = src;
		this.count = count;
		this.salecount = salecount;
		this.recommend = recommend;
		this.category = category;
		this.price = price;
		this.ddprice = ddprice;
		this.bookname = bookname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Date getPrinttime() {
		return printtime;
	}
	public void setPrinttime(Date printtime) {
		this.printtime = printtime;
	}
	public String getPrint() {
		return print;
	}
	public void setPrint(String print) {
		this.print = print;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getWordcount() {
		return wordcount;
	}
	public void setWordcount(Integer wordcount) {
		this.wordcount = wordcount;
	}
	public Integer getPagecount() {
		return pagecount;
	}
	public void setPagecount(Integer pagecount) {
		this.pagecount = pagecount;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public String getPackaeg() {
		return packaeg;
	}
	public void setPackaeg(String packaeg) {
		this.packaeg = packaeg;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getSalecount() {
		return salecount;
	}
	public void setSalecount(Integer salecount) {
		this.salecount = salecount;
	}
	public Integer getRecommend() {
		return recommend;
	}
	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDdprice() {
		return ddprice;
	}
	public void setDdprice(Double ddprice) {
		this.ddprice = ddprice;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	@Override
	public String toString() {
		return "Dbook [id=" + id + ", author=" + author + ", createdate="
				+ createdate + ", company=" + company + ", edition=" + edition
				+ ", printtime=" + printtime + ", print=" + print + ", isbn="
				+ isbn + ", wordcount=" + wordcount + ", pagecount="
				+ pagecount + ", format=" + format + ", paper=" + paper
				+ ", packaeg=" + packaeg + ", src=" + src + ", count=" + count
				+ ", salecount=" + salecount + ", recommend=" + recommend
				+ ", category=" + category + ", price=" + price + ", ddprice="
				+ ddprice + ", bookname=" + bookname + "]";
	}
	

}
