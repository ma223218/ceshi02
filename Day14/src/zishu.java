import java.util.ArrayList;
import java.util.List;

public class zishu {
	public static void main(String[] args) {
		String sa = "????��ɽ���Ƶ�ͷ��¶��Ц�ݣ���������׷���ʦ����������������ʦʧ�٣��ҵ����ܾ�û�г�����"
				+ "���й�ʦ�䷨�����������ӿ�ѧϰ�����ͽ�������ͼ����ɽ֮ʯ�����ƽ��ҵ�ƿ��������˵����������ǿ�Ĳ���ս��������ս������";
		
//		String sa = "????��ɽ���Ƶ�ͷ��¶��Ц�ݣ���������׷���ʦ����������������ʦʧ�٣��ҵ����ܾ�û�г�����"
//				+ "���й�ʦ�䷨�����������ӿ�ѧϰ�����ͽ�������ͼ����ɽ֮ʯ�����ƽ��ҵ�ƿ����";
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

	
	
	
	