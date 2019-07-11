package com.zd.test;
import org.junit.Test;
import com.zd.service.EmpService;
import com.zd.service.impl.EmpServiceImpl;

public class test1 extends EmpServiceImpl {

	@Test
	public void test() {
		EmpService ss=new EmpServiceImpl();
		System.out.println(ss.queryAllEmp());
	}
	
}
