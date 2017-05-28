package TestBufferedReaderWriter;
//��������ʹ��(�����ַ�)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestBufferedReaderWriter {
 @Test	
	public void test(){
	BufferedReader bi = null;
	BufferedWriter bo = null;
	try {
		//��������Ͷ�ȡ�Ķ���
		File file = new File("Hello.txt");
		File file1 = new File("Hello7.txt");
		//�ṩ������
		FileReader fi = new FileReader(file);
		FileWriter fo = new FileWriter(file1);
		bi = new BufferedReader(fi);
		bo = new BufferedWriter(fo);
		String str;
		//��ʼ��ȡ
		while((str = bi.readLine()) != null)//��ȡһ�С�����ȡ���ļ�ĩβ���򷵻ؿ�
		{
			bo.write(str);
			bo.newLine();//���У���Ϊ����ʹ��readLine()д��ʱ�����Զ�����
			bo.flush();
		}
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	if(bi != null)
	{
		try {
			bi.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
}
