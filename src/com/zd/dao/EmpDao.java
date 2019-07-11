package com.zd.dao;

import java.util.List;

import com.zd.pojo.Emp;
import com.zd.pojo.FenYe;
import com.zd.pojo.Query;

public interface EmpDao {
	/**
	 *查询所有员工
	 */
	public List<Emp> queryAllEmp();
	/**
	 * 添加员工
	 */
	public int addEmp(Emp emp);
	/**
	 * 根据id删除员工
	 */
	public int deleteEmpById(int id);
	/**
	 * 根据id查询员工
	 */
	public Emp queryEmpById(int id);
	/**
	 * 修改员工
	 */
	public int updateEmp(Emp emp);
	
	/**
	 * 分页查询
	 */
	public List<Emp> queryEmpByFy(FenYe fy);
	/**
	 * 查询记录总条数
	 */
	public int queryRowCount(Query query);
	
}
