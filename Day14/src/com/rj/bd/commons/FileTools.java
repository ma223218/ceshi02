package com.rj.bd.commons;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * @desc	����commons-io.jar�����ı�����������
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
