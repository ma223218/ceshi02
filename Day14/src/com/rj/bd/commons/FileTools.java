package com.rj.bd.commons;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * @desc	利用commons-io.jar创建文本操作工具类
 * @author DELL
 * @time	2020-10-08
 */
public class FileTools {
	
	public void getLinesByRead(String pathname) throws IOException  {
		
		File file=new File(pathname);
		List<String> list=FileUtils.readLines(file,"GBK");
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
