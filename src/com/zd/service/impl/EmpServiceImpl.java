package com.zd.service.impl;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.zd.dao.EmpDao;
import com.zd.pojo.Emp;
import com.zd.pojo.FenYe;
import com.zd.pojo.Query;
import com.zd.service.EmpService;
import com.zd.util.MybatisUtil;

public class EmpServiceImpl implements EmpService {

	@Override
	public List<Emp> queryAllEmp() {
		//1. 获取数据库连接
		SqlSession ss=MybatisUtil.init().getSqlSession();
		//2. 通过SqlSession获取dao层接口对应的实现类
		EmpDao ud=ss.getMapper(EmpDao.class);//Class
		//3. 调用对应的方法
		List<Emp> us=ud.queryAllEmp();
		//4. 关闭资源
		ss.close();//相当于把数据库连接放回到连接池
		return us;
	}

	@Override
	public int deleteEmpById(String[] ids) {
		SqlSession ss=MybatisUtil.init().getSqlSession();
		EmpDao nd=ss.getMapper(EmpDao.class);
		for(String str:ids) {
			nd.deleteEmpById(new Integer(str));
		}
		ss.close();
		return 1;
	}

	@Override
	public int addEmp(Emp n) {
		SqlSession ss=MybatisUtil.init().getSqlSession();
		EmpDao nd=ss.getMapper(EmpDao.class);
		int result=nd.addEmp(n);
		ss.close();
		return result;
	}

	@Override
	public Emp queryEmpById(int id) {
		SqlSession ss=MybatisUtil.init().getSqlSession();
		EmpDao nd=ss.getMapper(EmpDao.class);
		Emp n=nd.queryEmpById(id);
		ss.close();
		return n;
	}

	@Override
	public int updateEmp(Emp n) {
		SqlSession ss=MybatisUtil.init().getSqlSession();
		EmpDao nd=ss.getMapper(EmpDao.class);
		int result=nd.updateEmp(n);
		ss.close();
		return result;
	}

	@Override
	public List<Emp> queryEmpByFy(FenYe fy, String page, Query query) {
		SqlSession ss=MybatisUtil.init().getSqlSession();
		EmpDao nd=ss.getMapper(EmpDao.class);
		fy.setRowCount(nd.queryRowCount(query));
		if(page==null || "".equals(page)) {
			page="1";
		}
		//为了防止用户随意输入当前页面:如果大于总页数默认访问最后一页,小于1访问第一页
		int pageInt=new Integer(page);
		if(pageInt<1) {
			pageInt=1;
		}
		if(pageInt>fy.getPageCount() && fy.getPageCount()>0){
			pageInt=fy.getPageCount();
		}
		fy.setPage(pageInt);
		//设置查询条件对象
		fy.setQuery(query);
		List<Emp> ns=nd.queryEmpByFy(fy);
		ss.close();
		return ns;
	}

}
