package com.rj.bd.spiders.mp4;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @desc	利用Jsoup抓取视频
 * @author DELL
 * @time	2020-10-08
 */
public class Test {

	public static void main(String[] args) throws IOException {
		//网络资源
		String url="http://699pic.com/video-sousuo-0-2-1-200-0-0.html?sem=1&sem_kid=126640&sem_type=2";
		
		//获取Document
		Document document = Jsoup.connect(url).post();
		
		//分析规律，爬取视频
		Elements mp4List = document.getElementsByAttributeValue("class", "video-hover ");
		Elements mp4NameList = document.getElementsByTag("h3");
		
		for (int i = 0; i < mp4List.size(); i++) {
			
			Element everyMp4UrlElement = mp4List.get(i);
			String everyMp4Url=everyMp4UrlElement.attr("data-original");
			
			Element everyMp4NameElement= mp4NameList.get(i);
			String everyMp4Name=everyMp4NameElement.text();
			
			dowload("http:"+everyMp4Url,"F:/aaa/mp4/",everyMp4Name);
			
		}
		
		System.out.println("结束");
		
		
		
		
	}

	private static void dowload(String url,String purposePath,String everyMp4Name) throws IOException {
		
		URL source=new URL(url);
		String pathName=purposePath+everyMp4Name+".mp4";
		File file=new File(pathName);
		FileUtils.copyURLToFile(source, file);
		System.out.println(everyMp4Name+"下载完成");
	}
	
	

}
