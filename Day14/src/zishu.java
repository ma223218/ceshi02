import java.util.ArrayList;
import java.util.List;

public class zishu {
	public static void main(String[] args) {
		String sa = "????霸山祭酒点头，露出笑容：“当年我追随恩师修炼刀法，后来恩师失踪，我刀法很久没有长进，"
				+ "又有国师变法，所以来到延康学习法术和剑术，试图借他山之石，来破解我的瓶颈。不过说起来，我最强的不是战技，而是战法。”";
		
//		String sa = "????霸山祭酒点头，露出笑容：“当年我追随恩师修炼刀法，后来恩师失踪，我刀法很久没有长进，"
//				+ "又有国师变法，所以来到延康学习法术和剑术，试图借他山之石，来破解我的瓶颈”";
//		
//		System.out.println(sa.length());
		List<String> list = splitString(sa, 80);
		for (String string : list) {
			System.out.println(string);
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

	
	
	
	