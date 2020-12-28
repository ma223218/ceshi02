package com.rj.bd.flushs;
/**
 * @desc   ����Poi����һ��������
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

	
//1.ͨ��·����ȡ��ͬ�汾��excel
public Workbook getWrokBook(String pathname) throws IOException
{
	Workbook wb=null;
	Sheet sheet;
	Row row;
	Cell cell;
	//1.��excelת��Ϊfile����
	File file=new File(pathname);
	
	//2.��file����ת��Ϊ������
	FileInputStream fileInputStream=new FileInputStream(file);
	
	//3.�ж�
	if (file.isFile()&&file.exists())
	{
		//3.1��ȡ��ǰexcel������
		String excelName = file.getName();
        //System.out.println("excelName:"+excelName);			
		//3.2��ȡ�ļ��ĺ�׺
        int st = excelName.lastIndexOf(".");
	    String suffix = (String) excelName.subSequence(st+1, excelName.length());
		//System.out.println("suffix:"+suffix);
	    //3.3ͨ���ļ��ĺ�׺ʵ�ֶ�·�ж�
	    if (suffix.equals("xls"))
	    {
		   System.out.println("��2003����");	
		    wb=new HSSFWorkbook(fileInputStream);
		}
	    else if (suffix.equals("xlsx")) 
	    {
		  System.out.println("��2007����");	
		   wb=new XSSFWorkbook(fileInputStream);
		}
	    else 
	    {
		  System.out.println("��ǰ�ļ����ܽ������˳�����");
		  System.exit(0);
		}
}
	return wb;
}



//2.��ȡÿһ��excel�е�нˮ���е�ֵ��Ȼ����뵽������
public List<String> getCellData(Workbook workbook,int sheetNum,int beginColumn,int endColumn)
{
	Sheet sheet ;
	Row row;
	Cell cell;
	sheet= workbook.getSheetAt(sheetNum);//��ȡ�ڼ�ҳ
	List<String> list=new ArrayList<String>();	
		int totalRows = sheet.getPhysicalNumberOfRows();
		//System.out.println(totalRows);
		
		for(int i =0;i<totalRows;i++)//���ѭ���ǻ�ȡexcel�е���
		{
			row= sheet.getRow(i);//ͨ��sheet��ȡ��row����
		
		     for(int k=beginColumn;k<=endColumn;k++)//���ѭ���ǻ�ȡexcel�е���
		     {
		    	 cell= row.getCell(k);
		    	 String cellValue = getValue(cell);
		    	 list.add(cellValue);
		     }
		}
		return list;
}


//�����ʽ��
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
