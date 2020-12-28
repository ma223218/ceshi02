package com.rj.bd.spiders.text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class mushen {
	public static void main(String[] args) throws IOException {
		//首页https://www.bqg8.la/
		//更改的值
		String s = "34021518";
		//网址固定的
		String urlHtml="https://www.bqg8.la/5_5420/"+s+".html";
		
		//通过Jsoup获取document对象
		Document document = Jsoup.connect(urlHtml).post();
		
		//通过属性匹配获取爬取文本内容
		Elements main_element = document.getElementsByAttributeValue("id", "content");
		
		//字符串数组输出
		String [] a =main_element.eachText().get(0).split(" ");
		for (String string : a) {
			if (string.length()>80) {
				List<String> list = splitString(string, 80);
				for (String str : list) {
					System.out.println(str);
				}
				System.out.println();
			}
			else {
				System.out.println(string);
			}
			//System.out.println(string);
		}

	}
	public static List<String> splitString(String str,int length){
		List<String> ret=new ArrayList<String>();
		if(length>=str.length()){
		ret.add(str);
		}else{
		//如何填写这段代码?
			while(length<str.length())
			{ 
				ret.add(str.substring(0,length)); 
				str = str.substring(length,str.length());
			}
			ret.add(str);
		}
		return ret;

		}
}




