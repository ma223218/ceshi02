package com.rj.bd.flushs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * @desc   测试类：测试利用Poi获取excel中的数据，然后实现归类统计
 * @author DELL
 * @time   2020-10-11
 */
public class Test {

	public static void main(String[] args) throws IOException {

		//创建一个List将执行之后获取到的list存起来
		List<List<String>> list=new ArrayList<List<String>>();
		
		for(int i =1;i<=3;i++)
		{
		String pathname="F:/aaa/excel/zhyc-java0-"+i+".xls";
		
		FileUtils fileUtils=new FileUtils();
		Workbook workBook = fileUtils.getWrokBook(pathname);
	    List<String> resultList = fileUtils.getCellData(workBook, 0, 2, 2);
		list.add(resultList);//将获取到的三个excel中的薪水存入到list容器中
		}
		
		
		int h=0,m=0,l=0;
		  for(int i =0;i<list.size();i++)
		  {
			  List<String> everyResultList = list.get(i);//每一个excel中的薪水所在的容器
			  for(int k=0;k<everyResultList.size();k++)
			  {
				String everyResult = everyResultList.get(k);//每一个excel中的每一条的薪水
				
				if (!(everyResult.startsWith("其他")||everyResult.startsWith("薪")||everyResult.startsWith("面议")))
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
		
		
		
		System.out.println("12000以上的有："+h+"个");
		System.out.println("8000--12000的有："+m+"个");
		System.out.println("8000以下的有："+l+"个");
		
		
	}

}
