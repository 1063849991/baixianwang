package com.zd.service;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.zd.pojo.Emp;

public interface FileUpLoadService {
	public Emp newsUpload(List<FileItem> fs);
}
