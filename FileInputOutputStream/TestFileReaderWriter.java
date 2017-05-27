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
	//创建读入和写入文件
	File file = new File("Hello.txt");//读入文件必须存在
	File file2 = new File("Hello4.txt");//写入文件可存在也可不存在，存在则会被覆盖。不存在则会创建
	//提供流
	try{
	fis = new FileReader(file);
	fos = new FileWriter(file2);
	char[] b = new char[24];//定义字符数组的大小
	int len;
	//开始复制文件
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
