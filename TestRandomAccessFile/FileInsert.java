package TestRandomAccessFile;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;
//实现从一个文件的任意位置插入数据而不覆盖
public class FileInsert {
@Test
	public void test(){
	RandomAccessFile file = null;
	try {
		file = new RandomAccessFile(new File("hello.txt"), "rw");
		
		file.seek(3);//将指针移动到第四个元素
		//将第四个元素后的内容存到字符串中
		byte[] b = new byte[10];
		int len;
		StringBuffer str = new StringBuffer();
		while((len = file.read(b)) != -1)
		{
			str.append(new String(b, 0, len));//调用append方法可以一只对字符串进行扩充
		}
		file.seek(3);//再将经过read()后的指针移动到第四个元素
		file.write("ZZ".getBytes());//插入元素
		file.write(str.toString().getBytes());//写入后续的元素
	}catch (IOException e) {
		e.printStackTrace();
	}
	finally{
	try {
		if(file != null)
		{
			file.close();
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
	
	
}
}
