package com.rj.bd.spiders.zp;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * @desc   excel
 * @author DELL
 * @time   2020-10-08
 */
public class ExcelTools {

	

public void writeExcel(List<Job> list,String pathName,String keyWord) throws IOException, RowsExceededException, WriteException, InterruptedException
{
	File file=new File(pathName);
	
	WritableWorkbook workBook = Workbook.createWorkbook(file);
	
	WritableSheet sheet = workBook.createSheet("zhyc-"+keyWord, 0);
	
	
	sheet.addCell(new Label(0, 0, "岗位名称"));
	sheet.addCell(new Label(1, 0, "发布日期"));
	sheet.addCell(new Label(2, 0, "薪水"));
	sheet.addCell(new Label(3, 0, "地域"));
	sheet.addCell(new Label(4, 0, "工作经验"));
	sheet.addCell(new Label(5, 0, "学历"));
	sheet.addCell(new Label(6, 0, "公司名称"));
	
	
	int row=1;
	for(int i =0;i<list.size();i++)
	{
		Job job = list.get(i);
		sheet.addCell(new Label(0, row, job.getJobName()));
		sheet.addCell(new Label(1, row, job.getDate()));
		sheet.addCell(new Label(2, row, job.getMoney()));
		sheet.addCell(new Label(3, row, job.getCityArea()));
		sheet.addCell(new Label(4, row, job.getRecord()));
		sheet.addCell(new Label(5, row, job.getNacture()));
		sheet.addCell(new Label(6, row, job.getCompany()));
        row++;
	}
	
	
	workBook.write();
	Thread.sleep(3000);
	workBook.close();
	
	
	

}
	
	
	
	
}
