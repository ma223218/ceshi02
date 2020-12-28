package com.rj.bd.spiders.text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @desc	利用Jsoup实现爬取文本内容
 * @author DELL
 * @time	2020-10-07
 */
public class Test {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String s = "249844/5233795";
		String urlHtml="https://www.qu.la/book/"+s+".html";
		String urlHtml2="https://www.qu.la/book/"+s+"_2.html";
		
		Document document = Jsoup.connect(urlHtml).post();
		Document document2 = Jsoup.connect(urlHtml2).post();
		
		Elements main_element = document.getElementsByAttributeValue("class", "content");
		Elements main_element2 = document2.getElementsByAttributeValue("class", "content");
		
		String [] a =main_element.eachText().get(0).split(" ");
		for (String string : a) {
			System.out.println(string);
			
		}
		String [] a2 =main_element2.eachText().get(0).split(" ");
		for (String string : a2) {
			System.out.println(string);
		}
		
		
	}
}
