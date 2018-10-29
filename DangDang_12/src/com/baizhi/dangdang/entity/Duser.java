package com.baizhi.dangdang.entity;

import java.io.Serializable;

public class Duser implements Serializable{
	private String id;
	private String email;
	private String nickName;
	private String password;
	private Integer status;
	private String salt;
	public Duser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Duser(String id, String email, String nickName, String password,
			Integer status, String salt) {
		super();
		this.id = id;
		this.email = email;
		this.nickName = nickName;
		this.password = password;
		this.status = status;
		this.salt = salt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@Override
	public String toString() {
		return "Duser [id=" + id + ", email=" + email + ", nickName="
				+ nickName + ", password=" + password + ", status=" + status
				+ ", salt=" + salt + "]";
	}
	
	

}
