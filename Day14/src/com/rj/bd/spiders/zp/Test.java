package com.rj.bd.spiders.zp;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Document;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * @desc   ≤‚ ‘¿‡
 * @author DELL
 * @time   2020-10-08
 */
public class Test {

	public static void main(String[] args) throws IOException, RowsExceededException, WriteException, InterruptedException {

		      String keyWord="java";
		      for(int i =1;i<=3;i++)
		      {
		      String url="http://search.chinahr.com/bj/job/pn"+i+"/?key="+keyWord+"";
		      JsoupHtml jsoupHtml=new JsoupHtml();
		     
			  Document document = jsoupHtml.getDocument(url);
		      List<Job> list = jsoupHtml.getDataFromDocument(document);
		
		      ExcelTools excelTools=new ExcelTools();
		                       
			  excelTools.writeExcel(list, "F:/aaa/excel/zhyc-"+keyWord+"0-"+i+".xls", keyWord);
		      //Thread.sleep(1000);
		      
		      }
		      System.out.println("Ω· ¯");
	}

}
