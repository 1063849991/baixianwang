package com.zd.service.impl;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zd.dao.EmpDao;
import com.zd.pojo.Emp;
import com.zd.service.FileUpLoadService;

public class FileLoadServiceImpl implements FileUpLoadService {

	@Override
	public Emp newsUpload(List<FileItem> fs) {
		Emp e=new Emp();
		//处理list集合
		try {
			for (FileItem f : fs) {
				if (f.isFormField()){
					//是普通表单元素
					//获取表单元素的name属性值ֵ
					String inputName=f.getFieldName();
					String inputValue=f.getString("utf-8");
				
					if ("addEmpno".equals(inputName)) {
						if (inputValue!=null ) {
							e.setEmpno(new Integer(inputValue));
							System.out.println(inputValue);
						}
						
					}
					if ("addEname".equals(inputName)) {
						e.setEname(inputValue);
						System.out.println(inputValue);
					}
					if ("addJob".equals(inputName)) {
						e.setJob(inputValue);
						System.out.println(inputValue);
					}
					if ("addSal".equals(inputName)) {
						e.setSal(inputValue);
						System.out.println(inputValue);
					}
					if ("addComm".equals(inputName)) {
						e.setComm(inputValue);
						System.out.println(inputValue);
					}
					if ("addMgr".equals(inputName)) {
						if (inputValue!=null ) {
						e.setMgr(new Integer(inputValue));
						}
						System.out.println(inputValue);
					}
					if ("addDeptno".equals(inputName)) {
						if (inputValue!=null ) {
						e.setDeptno(new Integer(inputValue));
						}
						System.out.println(inputValue);
					}
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					if ("addHiredate".equals(inputName)) {
						if (inputValue!=null ) {
							e.setHiredate(sdf.parse(inputValue));
						}
						System.out.println(inputValue);
					}
				}else {
					//上传框
					//获取源文件名称
					String oldName=f.getName();
					System.out.println(oldName);
					if (oldName!=null && !"".equals(oldName)) {
						//随机生成一个36位的文件名称.jpg结尾
						String newName=UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."));
						//新建新文件
						File newFile=new File("D:/DianNaoDian/apache-tomcat-8.0.50/webapps/img/"+newName);
						//把FileItem里面的数据复制到新文件中即可
						f.write(newFile);
						e.setPic("../img/"+newName);
					}
				}
			}
		} catch (FileUploadException | ParseException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return e;
	}
}
