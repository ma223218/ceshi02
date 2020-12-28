package com.rj.bd.spiders.mp3;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @desc	爬取音频
 * @author DELL
 * @time	2020-01-08
 */
public class Test {

	public static void main(String[] args) throws IOException {
		
		
		for (int k = 0; k < 5; k++) {
			System.out.println("-------------第"+k+"页开始下载--------------");
			
			String url="https://www.i4.cn/ring_22_0_"+k+".html";
			
			Document document = Jsoup.connect(url).post();
			
			
			Elements btn_audio_play=document.getElementsByClass("btn audio_play");
			Elements nameCls =document.getElementsByAttributeValue("width", "28"); 
			
			for (int i = 0; i < btn_audio_play.size(); i++) {
				Element mp3UrlDiv=btn_audio_play.get(i);
				String everyMp3Url=mp3UrlDiv.attr("data-mp3");
				
				Element mp3Name=nameCls.get(i);
				String everyMp3Name=mp3Name.attr("title");
				dowloadMp3(everyMp3Url, "F:/aaa/mp3/", everyMp3Name);
				
			}
			
		}
		
		
		System.out.println("结束");
		
		

	}
	
	private static void dowloadMp3(String everyMp3Url,String purposePath,String everyMp3Name) throws IOException {
		
		URL url=new URL(everyMp3Url);
		
		String songNamePath=purposePath+everyMp3Name+".mp3";
		File file=new File(songNamePath);
		FileUtils.copyURLToFile(url, file);
		
		
	}
	
	
	
	

}
