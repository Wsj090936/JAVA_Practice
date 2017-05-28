package TestRandomAccessFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

public class TestRandomAccessFile {
@Test
	public void test(){
	//充当输入输出流
	RandomAccessFile file1 = null;
	RandomAccessFile file2 = null;
	try {
		file1 = new RandomAccessFile(new File("Hello.txt"), "r");//将访问方式设置为只读，就可以充当一个输入流
		file2 = new RandomAccessFile(new File("test3.txt"),"rw");//将访问方式设置为读写，就可以充当一个输出流
		
		//开始存入数据
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
