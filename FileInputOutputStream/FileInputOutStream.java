package FileInputOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class FileInputOutStream {
@Test//利用FileInputStream与FileOutputStream实现文件的复制
	public void testFileInputOutStream(){
	//1、创建读入和写入的文件
	File file1 = new File("Hello1.txt");
	File file2 = new File("Hello3.txt");
	FileInputStream fis = null;
	FileOutputStream fos = null;
	try{
		//2、提供流
	fis = new FileInputStream(file1);
	fos = new FileOutputStream(file2);
		//3、开始写入
	byte[] b = new byte[5];
	int len;
	//方法一
//	while((len = fis.read(b)) != -1)
//	{
//		for(int i = 0;i<len;i++)
//		{
//		fos.write(b[i]);
//		}
//	}
	//方法二
	while((len = fis.read(b)) != -1)
	{
		fos.write(b, 0, len);//从头开始写，写入长度为len个
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
