package com.zd.service;

import java.util.List;

import com.zd.pojo.Emp;
import com.zd.pojo.FenYe;
import com.zd.pojo.Query;

public interface EmpService {
	/**
	 *查询所有员工
	 */
	public List<Emp> queryAllEmp();
	/**
	 * 删除业务逻辑
	 */
	public int deleteEmpById(String[] ids);
	/**
	 * 添加
	 */
	public int addEmp(Emp n);
	/**
	 * 根据id查询
	 */
	public Emp queryEmpById(int id);
	/**
	 * 根据主键ID修改新闻
	 */
	public int updateEmp(Emp n);
	/**
	 * 分页业务逻辑
	 */
	public List<Emp> queryEmpByFy(FenYe fy,String page,Query query);
}
