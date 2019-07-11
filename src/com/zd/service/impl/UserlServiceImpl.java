package com.zd.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.zd.dao.EmpDao;
import com.zd.dao.UserlDao;
import com.zd.pojo.Emp;
import com.zd.pojo.Userl;
import com.zd.service.UserlService;
import com.zd.util.MybatisUtil;

public class UserlServiceImpl implements UserlService {

	@Override
	public Userl selectUser(Userl userl) {
		SqlSession ss=MybatisUtil.init().getSqlSession();
		UserlDao uu=ss.getMapper(UserlDao.class);
		//用来处理业务逻辑，不符合要求的数据就不然其经过dao层
		if (userl.getUserName()!=null && !"".equals(userl.getUserName())&&userl.getuPassword()!=null&&!"".equals(userl.getuPassword())) {
			userl=uu.selectUser(userl);
			ss.close();
			return userl;
		}
		ss.close();
		return null;
	}

	@Override
	public int addUserl(Userl n) {
		SqlSession ss=MybatisUtil.init().getSqlSession();
		UserlDao nd=ss.getMapper(UserlDao.class);
		int result=nd.addUserl(n);
		ss.close();
		return result;
	}

	@Override
	public Userl queryEmpByName(String username) {
		SqlSession ss=MybatisUtil.init().getSqlSession();
		UserlDao nd=ss.getMapper(UserlDao.class);
		Userl n=nd.queryEmpByName(username);
		ss.close();
		return n;
	}

}
