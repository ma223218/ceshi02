package com.rj.bd.spiders.zp;
/**
 * @desc   Jsoup½âÎö
 * @author DELL
 * @time   2020-10-08
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupHtml {

	
	

public Document getDocument(String url) throws IOException
{
	return Jsoup.connect(url).get();
}
	


public  List<Job> getDataFromDocument(Document document)
{
	 Elements jobList = document.getElementsByAttributeValue("class", "jobList pc_search_listclick");
	 List<Job> list=new ArrayList<Job>();
	 for(int i =0;i<jobList.size();i++)
	 {
		 Job job=new Job();
	   Element everyDivElement = jobList.get(i);
		 
	   Element ul01Element = everyDivElement.child(0);
		
	   String[] ul01Array = ul01Element.text().split(" ");
	   job.setJobName(ul01Array[0]);
	   job.setDate(ul01Array[1]);
	   
	   
	 
	   Element ul02Element = everyDivElement.child(1);
	   
	   String[] ul02Array = ul02Element.text().split(" ");
	   
	   job.setMoney(ul02Array[0]);
	   
	    if (ul02Array.length==9) 
	    {
	       job.setCityArea(ul02Array[1]);
	  	   job.setRecord(ul02Array[3]);
	  	   job.setNacture(ul02Array[5]);
	  	   job.setCompany(ul02Array[8]);
		}
	    else
	    {
	       job.setCityArea(ul02Array[2]);
	  	   job.setRecord(ul02Array[4]);
	  	   job.setNacture(ul02Array[6]);
	  	   job.setCompany(ul02Array[9]);
	    }  
	  
	   list.add(job);
	 }
	
	return list;
}




	
	
	
}
