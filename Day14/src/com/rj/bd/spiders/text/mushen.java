package com.rj.bd.spiders.text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class mushen {
	public static void main(String[] args) throws IOException {
		//��ҳhttps://www.bqg8.la/
		//���ĵ�ֵ
		String s = "34021518";
		//��ַ�̶���
		String urlHtml="https://www.bqg8.la/5_5420/"+s+".html";
		
		//ͨ��Jsoup��ȡdocument����
		Document document = Jsoup.connect(urlHtml).post();
		
		//ͨ������ƥ���ȡ��ȡ�ı�����
		Elements main_element = document.getElementsByAttributeValue("id", "content");
		
		//�ַ����������
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
		//�����д��δ���?
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




