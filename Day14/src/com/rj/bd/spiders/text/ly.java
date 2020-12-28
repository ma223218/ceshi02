package com.rj.bd.spiders.text;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ly{

	public static void main(String[] args) throws IOException {
		//更改的值
		String s = "6760478";
		//网址固定的
		String urlHtml="https://www.bqg8.la/9_9998/"+s+".html";
		
		//通过Jsoup获取document对象
		Document document = Jsoup.connect(urlHtml).post();
		
		//通过属性匹配获取爬取文本内容
		Elements main_element = document.getElementsByAttributeValue("id", "content");
		
		//字符串数组输出
		String [] a =main_element.eachText().get(0).split(" ");
		for (String string : a) {
			System.out.println(string);
		}
		
		

	}

}
