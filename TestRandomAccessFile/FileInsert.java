package TestRandomAccessFile;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;
//ʵ�ִ�һ���ļ�������λ�ò������ݶ�������
public class FileInsert {
@Test
	public void test(){
	RandomAccessFile file = null;
	try {
		file = new RandomAccessFile(new File("hello.txt"), "rw");
		
		file.seek(3);//��ָ���ƶ������ĸ�Ԫ��
		//�����ĸ�Ԫ�غ�����ݴ浽�ַ�����
		byte[] b = new byte[10];
		int len;
		StringBuffer str = new StringBuffer();
		while((len = file.read(b)) != -1)
		{
			str.append(new String(b, 0, len));//����append��������һֻ���ַ�����������
		}
		file.seek(3);//�ٽ�����read()���ָ���ƶ������ĸ�Ԫ��
		file.write("ZZ".getBytes());//����Ԫ��
		file.write(str.toString().getBytes());//д�������Ԫ��
	}catch (IOException e) {
		e.printStackTrace();
	}
	finally{
	try {
		if(file != null)
		{
			file.close();
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
	
	
}
}
