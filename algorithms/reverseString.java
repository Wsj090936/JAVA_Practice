package algorithms;
//ʵ�ֽ�����λ�õ��ַ�����ת
public class reverseString {

	public static void main(String[] args){
		String str = "asdfghjk";
		System.out.println(Reverse(str,0,3));
		Object B = new Object();
	}
	public	static String Reverse(String str,int start,int end){//������
		if(end-start<0){
			throw new RuntimeException("�±겻��");
		}else{
		char[] B = str.toCharArray();
		for(int i = start,j = end;i<j;i++,j--){
			char temp = B[i];
			B[i] = B[j];
			B[j] = temp;
		}

		return new String(B);
		
		
	}
}
}
