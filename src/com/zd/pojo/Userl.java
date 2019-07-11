package com.zd.pojo;

public class Userl {
	//用户id
	private Integer userId;
	//用户名
	private String userName;
	//用户密码
	private String uPassword;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	@Override
	public String toString() {
		return "Userl [userId=" + userId + ", userName=" + userName + ", uPassword=" + uPassword + "]";
	}
	
}
