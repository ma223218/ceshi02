package com.rj.bd.zp02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @desc   利用poi+excel模板实现数据的可视化
 * @author DELL
 * @time   2020-10-11
 */
public class Test {

	public static void main(String[] args) throws IOException {

		FileInputStream fileInputStream=new FileInputStream("F:/aaa/123.xlsx");
		
		FileOutputStream fileOutputStream=new FileOutputStream("F:/aaa/20201011.xlsx");
		
		XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
		
        sheet.setForceFormulaRecalculation(true);
        xssfWorkbook.setSheetName(0, "sheet0");
        XSSFCellStyle cellStyle = xssfWorkbook.createCellStyle();
        
        String []mingCheng={"java","php","python","C++"};//名称
        for(int i =1;i<=4;i++)
        {
         XSSFRow row = sheet.getRow(i);//获取四行对象        	
         XSSFCell cell = row.getCell(0);//获取每一行的第一列	
         cell.setCellValue(mingCheng[i-1]);	
        }
        
        
        int [] shuLiang={800,500,260,100};//修改的值
        for(int k =1;k<=4;k++)
        {
        XSSFRow row2 = sheet.getRow(k);
        XSSFCell cell2 = row2.getCell(1);	
        cell2.setCellValue(shuLiang[k-1]);	
        }
        
        
       //7.写入
        xssfWorkbook.write(fileOutputStream);
        
        //8.关闭
        fileInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
        System.out.println("结束");
	}

}
