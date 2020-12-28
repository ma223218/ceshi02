package com.rj.bd.flushs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * @desc   �����ࣺ��������Poi��ȡexcel�е����ݣ�Ȼ��ʵ�ֹ���ͳ��
 * @author DELL
 * @time   2020-10-11
 */
public class Test {

	public static void main(String[] args) throws IOException {

		//����һ��List��ִ��֮���ȡ����list������
		List<List<String>> list=new ArrayList<List<String>>();
		
		for(int i =1;i<=3;i++)
		{
		String pathname="F:/aaa/excel/zhyc-java0-"+i+".xls";
		
		FileUtils fileUtils=new FileUtils();
		Workbook workBook = fileUtils.getWrokBook(pathname);
	    List<String> resultList = fileUtils.getCellData(workBook, 0, 2, 2);
		list.add(resultList);//����ȡ��������excel�е�нˮ���뵽list������
		}
		
		
		int h=0,m=0,l=0;
		  for(int i =0;i<list.size();i++)
		  {
			  List<String> everyResultList = list.get(i);//ÿһ��excel�е�нˮ���ڵ�����
			  for(int k=0;k<everyResultList.size();k++)
			  {
				String everyResult = everyResultList.get(k);//ÿһ��excel�е�ÿһ����нˮ
				
				if (!(everyResult.startsWith("����")||everyResult.startsWith("н")||everyResult.startsWith("����")))
				{
					
					int st = everyResult.lastIndexOf("-");
					String ft = (String) everyResult.subSequence(0,st);
					if (Integer.parseInt(ft)>12000) 
					{
					  h++;	
					}
					else if ((Integer.parseInt(ft)>=8000)&&(Integer.parseInt(ft)<=12000))
					{
						m++;
					}
					else 
					{
						l++;
					}
				}
			  }
			  
		  }
		
		
		
		System.out.println("12000���ϵ��У�"+h+"��");
		System.out.println("8000--12000���У�"+m+"��");
		System.out.println("8000���µ��У�"+l+"��");
		
		
	}

}
