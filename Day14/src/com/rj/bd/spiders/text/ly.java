package com.rj.bd.spiders.text;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ly{

	public static void main(String[] args) throws IOException {
		//���ĵ�ֵ
		String s = "6760478";
		//��ַ�̶���
		String urlHtml="https://www.bqg8.la/9_9998/"+s+".html";
		
		//ͨ��Jsoup��ȡdocument����
		Document document = Jsoup.connect(urlHtml).post();
		
		//ͨ������ƥ���ȡ��ȡ�ı�����
		Elements main_element = document.getElementsByAttributeValue("id", "content");
		
		//�ַ����������
		String [] a =main_element.eachText().get(0).split(" ");
		for (String string : a) {
			System.out.println(string);
		}
		
		

	}

}
