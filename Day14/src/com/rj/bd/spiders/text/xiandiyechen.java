package com.rj.bd.spiders.text;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class xiandiyechen {

	public static void main(String[] args) throws IOException {
		String s = "37510519";
		String urlHtml="https://www.bqg8.la/75_75270/"+s+".html";
		
		Document document = Jsoup.connect(urlHtml).post();
		
		Elements main_element = document.getElementsByAttributeValue("id", "content");
		
		String [] a =main_element.eachText().get(0).split(" ");
		for (String string : a) {
			System.out.println(string);
		}
		
		

	}

}
