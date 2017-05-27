package FileInputOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

public class TestFileInputStream {
@Test
//一、FileInputStreamd的使用
	public void test() throws IOException{//使用try-catch的方式处理异常更合理
	File file = new File("Hello.txt");//创建File类对象
	FileInputStream fil = new FileInputStream(file);//创建一个FileInputStream类对象将需要操作的File类作为形参传入进去
	int b = fil.read();//调用FileInpotStream中的方法去读取文件中的一个字节，若读取到文件的末尾了，则会返回-1
	while(b != -1)
	{
		System.out.println((char)b);
		b = fil.read();
	}
	fil.close();
}
@Test//try-catch处理异常
	public void test2(){
		FileInputStream fil = null;
		try {
			File file = new File("Hello.txt");//创建File类对象
			fil = new FileInputStream(file);
			int b = fil.read();//调用FileInpotStream中的方法去读取文件中的一个字节，若读取到文件的末尾了，则会返回-1
			while(b != -1)
			{
				System.out.println((char)b);
				b = fil.read();
			}
		} catch (IOException e) {//当文件不存在或者IO的异常则执行
			e.printStackTrace();
		}finally{//保证一定能关闭流
		try {
			fil.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}
//利用read(byte[] b)方法对文件进行读取
@Test
	public void test3(){
	FileInputStream fil = null;
	try {
		File file = new File("Hello.txt");
		fil = new FileInputStream(file);
		byte[] b = new byte[5];//利用byte型数组存放读取的数据，定义每次读取5个字节
		int len;
		while((len = fil.read(b))!=-1)//read(byte[] b)的返回值是int型的，为其存储字节的个数，若已经读到文件末尾了则返回-1
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
