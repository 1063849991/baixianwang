package com.zd.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private SqlSessionFactory ssf;
	private static MybatisUtil mu=new MybatisUtil();
	//单例工具类：获取数据库连接
	private MybatisUtil() {
		//通过类加载器把主配置文件转换成输入流
		InputStream is=MybatisUtil.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
		//加载主配置文件获取SqlSessionFactory对象
		ssf=new SqlSessionFactoryBuilder().build(is);
	}
	public static MybatisUtil init() {
		return mu;
	}
	public SqlSession getSqlSession() {
		return ssf.openSession(true);
	}
	
}
