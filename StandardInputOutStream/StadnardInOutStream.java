package StandardInputOutStream;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//��׼����������� System.in  System.out
//ʵ���ַ���Сдת���ɴ�д�����롰e����exit���˳�
import org.junit.Test;

public class StadnardInOutStream {
@Test
	public void test(){
	BufferedReader br = null;
	try {
		InputStream ist = System.in;//System.in���ص����ֽ��͵�����
		InputStreamReader isr = new InputStreamReader(ist);//ת��Ϊ�ַ���
		 br = new BufferedReader(isr);
		String str;
		while(true)
		{
			System.out.println("�������ַ���");
			str = br.readLine();
			if(str.equalsIgnoreCase("e")||str.equalsIgnoreCase("exit"))
			{
				break;
			}
			String str1 = str.toUpperCase();//ת��Ϊ��д
			System.out.println(str1);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(br != null)
		{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
}
