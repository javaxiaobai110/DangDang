package com.baizhi.dangdang.entity;

import java.io.Serializable;

public class Address implements Serializable{
	private String id;
	private String reciveName;
	private String detailAddress;
	private String telNumber;
	private String phoneNumber;
	private Duser duser;
	private String zipcode;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String id, String reciveName, String detailAddress,
			String telNumber, String phoneNumber, Duser duser, String zipcode) {
		super();
		this.id = id;
		this.reciveName = reciveName;
		this.detailAddress = detailAddress;
		this.telNumber = telNumber;
		this.phoneNumber = phoneNumber;
		this.duser = duser;
		this.zipcode = zipcode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReciveName() {
		return reciveName;
	}
	public void setReciveName(String reciveName) {
		this.reciveName = reciveName;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Duser getDuser() {
		return duser;
	}
	public void setDuser(Duser duser) {
		this.duser = duser;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", reciveName=" + reciveName
				+ ", detailAddress=" + detailAddress + ", telNumber="
				+ telNumber + ", phoneNumber=" + phoneNumber + ", duser="
				+ duser + ", zipcode=" + zipcode + "]";
	}
	
}
