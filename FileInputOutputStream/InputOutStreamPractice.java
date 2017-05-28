package FileInputOutputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

//使用字节流实现内容的输入和输出
public class InputOutStreamPractice {
@Test
	public void test(){
	BufferedOutputStream bos = null;
	try {
		bos = new BufferedOutputStream(new FileOutputStream(new File("test.txt")));
		byte[] str = new String("我是帅哥！哈哈哈哈"
				+ "无敌~~").getBytes();
		bos.write(str);
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
	try {
		if(bos != null)
		{
			bos.close();
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
}
