package com.rj.bd.flushs;
/**
 * @desc   利用Poi构建一个工具类
 * @author DELL
 * @time	2020-10-11
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileUtils {

	
//1.通过路径获取不同版本的excel
public Workbook getWrokBook(String pathname) throws IOException
{
	Workbook wb=null;
	Sheet sheet;
	Row row;
	Cell cell;
	//1.将excel转变为file对象
	File file=new File(pathname);
	
	//2.将file对象转变为流对象
	FileInputStream fileInputStream=new FileInputStream(file);
	
	//3.判断
	if (file.isFile()&&file.exists())
	{
		//3.1获取当前excel的名字
		String excelName = file.getName();
        //System.out.println("excelName:"+excelName);			
		//3.2获取文件的后缀
        int st = excelName.lastIndexOf(".");
	    String suffix = (String) excelName.subSequence(st+1, excelName.length());
		//System.out.println("suffix:"+suffix);
	    //3.3通过文件的后缀实现多路判断
	    if (suffix.equals("xls"))
	    {
		   System.out.println("走2003解析");	
		    wb=new HSSFWorkbook(fileInputStream);
		}
	    else if (suffix.equals("xlsx")) 
	    {
		  System.out.println("走2007解析");	
		   wb=new XSSFWorkbook(fileInputStream);
		}
	    else 
	    {
		  System.out.println("当前文件不能解析，退出程序");
		  System.exit(0);
		}
}
	return wb;
}



//2.读取每一个excel中的薪水这列的值，然后存入到容器中
public List<String> getCellData(Workbook workbook,int sheetNum,int beginColumn,int endColumn)
{
	Sheet sheet ;
	Row row;
	Cell cell;
	sheet= workbook.getSheetAt(sheetNum);//获取第几页
	List<String> list=new ArrayList<String>();	
		int totalRows = sheet.getPhysicalNumberOfRows();
		//System.out.println(totalRows);
		
		for(int i =0;i<totalRows;i++)//外层循环是获取excel中的行
		{
			row= sheet.getRow(i);//通过sheet获取到row对象
		
		     for(int k=beginColumn;k<=endColumn;k++)//里层循环是获取excel中的列
		     {
		    	 cell= row.getCell(k);
		    	 String cellValue = getValue(cell);
		    	 list.add(cellValue);
		     }
		}
		return list;
}


//输出格式化
public  String getValue(Cell cell)
{
	if (cell.getCellType()==Cell.CELL_TYPE_NUMERIC) 
	{
	             return String.valueOf((int)cell.getNumericCellValue());	
	}
	else if (cell.getCellType()==Cell.CELL_TYPE_BOOLEAN) 
	{
		          return String.valueOf(cell.getBooleanCellValue());
	}
	return cell.getStringCellValue();
}



}
