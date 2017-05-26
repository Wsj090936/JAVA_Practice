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
	System.out.println(file.getName());//得到当前文件的名字
	System.out.println(file.getPath());//得到当前文件的路径
	System.out.println(file.getAbsolutePath());//得到当前文件的绝对路径(包括盘符在内的完整的路径)
	System.out.println(file1.getAbsoluteFile());//获取绝对文件名
	System.out.println(file1.getParent());//得到当前文件的上一个文件的目录
	System.out.println(file1.renameTo(file2));//将当前文件重命名为file2的名字，要求当前文件必须存在，file2文件必须不存在
	}
	@Test
	public void TestFile2(){
		//文件类型的操作
		File file = new File("J:\\JAVASE\\HelloWorld.txt");
		System.out.println(file.exists());//判断文件是否存在
		System.out.println(file.canWrite());//判断文件是否可写
		System.out.println(file.canRead());//判断文件是否可读
		System.out.println(file.isFile());//判断是否为文件
		System.out.println(file.isDirectory());//判断是否为目录
		System.out.println(file.lastModified());//获取当前文件的最后修改时间
		System.out.println(file.length());//获取当前文件长度
	}
	@Test
	public void TestFile3() throws IOException{
		File file = new File("J:\\JAVASE\\HelloWorld.docx");
		System.out.println(file.createNewFile());//若文件不存在，则创建一个新的文件
		System.out.println(file.delete());//删除文件或目录
		File file1 = new File("J:\\JAVASE\\JAVA222");
		System.out.println(file1.mkdir());//创建目录
		File file2 = new File("J:\\JAVASE\\JAVA333\\JAVA444");
		System.out.println(file2.mkdirs());//创建多层目录
		File file3 = new File("J:\\JAVASE");
		String[] str = file3.list();//显示该目录下的所有文件
		for(int i = 0;i<str.length;i++)
		{
			System.out.println(str[i]);
		}
		File[] str1 = file3.listFiles();//附带路径名显示该目录下的所有
		for(int i = 0;i<str.length;i++)
		{
			System.out.println(str1[i]);
		}
	}
}
