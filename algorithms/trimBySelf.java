package algorithms;
//��String��ķ����Լ�дһ��trim()ȥ���ַ�����λ�ո�ķ���
public class trimBySelf {
public static void main(String[] args) {
	String str = "   qw  er   ";
	System.out.println(myTrim(str));
}	
	
public static String myTrim(String str){
	int start = 0;
	int end = str.length()-1;
	while(start < end && str.charAt(start) == ' '){//��start��¼��һ�����ǿո��Ԫ�ص��±�
		start++;
	}
	while(start < end && str.charAt(end) == ' '){//��end��¼���ַ���ĩβ��ʼ��һ�����ǿո��Ԫ�ص��±�
		end--;
	}
	return str.substring(start, end+1);//end+1��ԭ����substring����������ҿ���
	
}
}
