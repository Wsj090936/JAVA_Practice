package TestRandomAccessFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

public class TestRandomAccessFile {
@Test
	public void test(){
	//�䵱���������
	RandomAccessFile file1 = null;
	RandomAccessFile file2 = null;
	try {
		file1 = new RandomAccessFile(new File("Hello.txt"), "r");//�����ʷ�ʽ����Ϊֻ�����Ϳ��Գ䵱һ��������
		file2 = new RandomAccessFile(new File("test3.txt"),"rw");//�����ʷ�ʽ����Ϊ��д���Ϳ��Գ䵱һ�������
		
		//��ʼ��������
		byte[] b = new byte[10];
		int len;
		while((len = file1.read(b)) != -1)
		{
			file2.write(b, 0, len);
		}
	}catch (IOException e) {
		e.printStackTrace();
	}
	finally{
	try {
		if(file2 != null)
		{
			file2.close();
		}
		if(file1 != null)
		{
			file1.close();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
  }
}
