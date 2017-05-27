package FileInputOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class FileInputOutStream {
@Test//����FileInputStream��FileOutputStreamʵ���ļ��ĸ���
	public void testFileInputOutStream(){
	//1�����������д����ļ�
	File file1 = new File("Hello1.txt");
	File file2 = new File("Hello3.txt");
	FileInputStream fis = null;
	FileOutputStream fos = null;
	try{
		//2���ṩ��
	fis = new FileInputStream(file1);
	fos = new FileOutputStream(file2);
		//3����ʼд��
	byte[] b = new byte[5];
	int len;
	//����һ
//	while((len = fis.read(b)) != -1)
//	{
//		for(int i = 0;i<len;i++)
//		{
//		fos.write(b[i]);
//		}
//	}
	//������
	while((len = fis.read(b)) != -1)
	{
		fos.write(b, 0, len);//��ͷ��ʼд��д�볤��Ϊlen��
	}
	}catch(IOException e)
	{
		e.printStackTrace();
	}finally{
		try {
			if(fis!=null)
			{
				fis.close();
			}
			if(fos!=null)
			{
				fos.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
}
