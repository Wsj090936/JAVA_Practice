package TestFile;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class TestFlie {
	@Test
	public void TestFile1(){
	File file = new File("hello.txt");
	File file1 = new File("J:\\JAVASE\\HelloWorld.docx");
	
	File file2 = new File("J:\\JAVASE\\HelloWorld.txt");
	System.out.println(file.getName());//�õ���ǰ�ļ�������
	System.out.println(file.getPath());//�õ���ǰ�ļ���·��
	System.out.println(file.getAbsolutePath());//�õ���ǰ�ļ��ľ���·��(�����̷����ڵ�������·��)
	System.out.println(file1.getAbsoluteFile());//��ȡ�����ļ���
	System.out.println(file1.getParent());//�õ���ǰ�ļ�����һ���ļ���Ŀ¼
	System.out.println(file1.renameTo(file2));//����ǰ�ļ�������Ϊfile2�����֣�Ҫ��ǰ�ļ�������ڣ�file2�ļ����벻����
	}
	@Test
	public void TestFile2(){
		//�ļ����͵Ĳ���
		File file = new File("J:\\JAVASE\\HelloWorld.txt");
		System.out.println(file.exists());//�ж��ļ��Ƿ����
		System.out.println(file.canWrite());//�ж��ļ��Ƿ��д
		System.out.println(file.canRead());//�ж��ļ��Ƿ�ɶ�
		System.out.println(file.isFile());//�ж��Ƿ�Ϊ�ļ�
		System.out.println(file.isDirectory());//�ж��Ƿ�ΪĿ¼
		System.out.println(file.lastModified());//��ȡ��ǰ�ļ�������޸�ʱ��
		System.out.println(file.length());//��ȡ��ǰ�ļ�����
	}
	@Test
	public void TestFile3() throws IOException{
		File file = new File("J:\\JAVASE\\HelloWorld.docx");
		System.out.println(file.createNewFile());//���ļ������ڣ��򴴽�һ���µ��ļ�
		System.out.println(file.delete());//ɾ���ļ���Ŀ¼
		File file1 = new File("J:\\JAVASE\\JAVA222");
		System.out.println(file1.mkdir());//����Ŀ¼
		File file2 = new File("J:\\JAVASE\\JAVA333\\JAVA444");
		System.out.println(file2.mkdirs());//�������Ŀ¼
		File file3 = new File("J:\\JAVASE");
		String[] str = file3.list();//��ʾ��Ŀ¼�µ������ļ�
		for(int i = 0;i<str.length;i++)
		{
			System.out.println(str[i]);
		}
		File[] str1 = file3.listFiles();//����·������ʾ��Ŀ¼�µ�����
		for(int i = 0;i<str.length;i++)
		{
			System.out.println(str1[i]);
		}
	}
}
