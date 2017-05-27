package FileInputOutputStream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestFileReaderWriter {
@Test
	public void test(){
	FileReader fis = null;
	FileWriter fos = null;
	//���������д���ļ�
	File file = new File("Hello.txt");//�����ļ��������
	File file2 = new File("Hello4.txt");//д���ļ��ɴ���Ҳ�ɲ����ڣ�������ᱻ���ǡ���������ᴴ��
	//�ṩ��
	try{
	fis = new FileReader(file);
	fos = new FileWriter(file2);
	char[] b = new char[24];//�����ַ�����Ĵ�С
	int len;
	//��ʼ�����ļ�
	while((len = fis.read(b)) != -1)
	{
		fos.write(b, 0, len);
	}
	}catch(IOException e)
	{
		e.printStackTrace();
	}finally{
		try {
			if(fos!=null)
			{
				fos.close();
			}
			if(fis!=null)
			{
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
}
