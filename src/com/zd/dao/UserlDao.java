package com.zd.dao;

import com.zd.pojo.Emp;
import com.zd.pojo.Userl;

public interface UserlDao {
	/*
	 * 用户登录
	 */
	public Userl selectUser(Userl userl);
	
	/**
	 * 添加用户
	 */
	public int addUserl(Userl Userl);
	/**
	 * 根据用户名查询
	 */
	public Userl queryEmpByName(String username);
}
