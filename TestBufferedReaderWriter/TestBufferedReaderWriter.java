package TestBufferedReaderWriter;
//缓冲流的使用(处理字符)
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
		//创建读入和读取的对象
		File file = new File("Hello.txt");
		File file1 = new File("Hello7.txt");
		//提供所需流
		FileReader fi = new FileReader(file);
		FileWriter fo = new FileWriter(file1);
		bi = new BufferedReader(fi);
		bo = new BufferedWriter(fo);
		String str;
		//开始读取
		while((str = bi.readLine()) != null)//读取一行。若读取到文件末尾，则返回空
		{
			bo.write(str);
			bo.newLine();//换行，因为它在使用readLine()写入时不会自动换行
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
