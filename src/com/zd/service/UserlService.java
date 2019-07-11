package com.zd.service;

import com.zd.pojo.Emp;
import com.zd.pojo.Userl;

public interface UserlService {
	/*
	 * 用户登录
	 */
	public Userl selectUser(Userl userl);
	/**
	 * 添加
	 */
	public int addUserl(Userl n);
	/**
	 * 根据用户名查询
	 */
	public Userl queryEmpByName(String username);
}
