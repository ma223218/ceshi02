package com.rj.bd.spiders.images;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @desc	利用Jsoup爬取图片
 * @author DELL
 * @time	2020-10-08
 */
public class Test {

	public static void main(String[] args) throws IOException {
		String url="https://tieba.baidu.com/p/6273075690";
		
		Document document = Jsoup.connect(url).post();
		
		String regex="img[src$=.jpg]";
		
		
		Elements imageList = document.select(regex);
		List<String> list=new ArrayList<String>();
		
		for (int i = 0; i < imageList.size(); i++) {
			Element everyImgElement=imageList.get(i);
			String everyImgUrl=everyImgElement.attr("src");
			if (everyImgUrl.startsWith("http")) {
				list.add(everyImgUrl);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			download(list.get(i), "F:/aaa/img/", 0+"-"+i);
		}
		
		
		
		System.out.println("结束");
		
		
		

	}
	
	public static void download(String everyImgUrl,String pathName,String fileName) throws IOException {
		
		URL url=new URL(everyImgUrl);
		String finishPath=pathName+fileName+".jpg";
		System.out.println("finisPath--->"+finishPath);
		File file=new File(finishPath);
		
		FileUtils.copyURLToFile(url, file);
		
	}

}
