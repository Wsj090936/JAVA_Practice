package FileInputOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

public class TestFileInputStream {
@Test
//һ��FileInputStreamd��ʹ��
	public void test() throws IOException{//ʹ��try-catch�ķ�ʽ�����쳣������
	File file = new File("Hello.txt");//����File�����
	FileInputStream fil = new FileInputStream(file);//����һ��FileInputStream�������Ҫ������File����Ϊ�βδ����ȥ
	int b = fil.read();//����FileInpotStream�еķ���ȥ��ȡ�ļ��е�һ���ֽڣ�����ȡ���ļ���ĩβ�ˣ���᷵��-1
	while(b != -1)
	{
		System.out.println((char)b);
		b = fil.read();
	}
	fil.close();
}
@Test//try-catch�����쳣
	public void test2(){
		FileInputStream fil = null;
		try {
			File file = new File("Hello.txt");//����File�����
			fil = new FileInputStream(file);
			int b = fil.read();//����FileInpotStream�еķ���ȥ��ȡ�ļ��е�һ���ֽڣ�����ȡ���ļ���ĩβ�ˣ���᷵��-1
			while(b != -1)
			{
				System.out.println((char)b);
				b = fil.read();
			}
		} catch (IOException e) {//���ļ������ڻ���IO���쳣��ִ��
			e.printStackTrace();
		}finally{//��֤һ���ܹر���
		try {
			fil.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}
//����read(byte[] b)�������ļ����ж�ȡ
@Test
	public void test3(){
	FileInputStream fil = null;
	try {
		File file = new File("Hello.txt");
		fil = new FileInputStream(file);
		byte[] b = new byte[5];//����byte�������Ŷ�ȡ�����ݣ�����ÿ�ζ�ȡ5���ֽ�
		int len;
		while((len = fil.read(b))!=-1)//read(byte[] b)�ķ���ֵ��int�͵ģ�Ϊ��洢�ֽڵĸ��������Ѿ������ļ�ĩβ���򷵻�-1
		{
			for(int i = 0;i<len;i++)
			{
			System.out.print((char)b[i]);
			}
		}
	} catch (IOException e) {
		e.printStackTrace();
	}finally{
		if(fil != null)
			try {
				fil.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
}
