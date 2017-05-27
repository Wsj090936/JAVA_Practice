package FileInputOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.junit.Test;

public class TestFileOutputStream {
@Test
	public void test1(){
	FileOutputStream fil = null;
	try{
	File file = new File("Hello1.txt");//创建一个File类型的文件作为被写入的对象，该文件可以不存在，若不存在，则会创建一个新文件，若存在，会覆盖原有文件
	fil = new FileOutputStream(file);//创建一个FileOutputStream的对象将file作为其构造器的形参
	fil.write(new String("I am a handsome boy!").getBytes());//执行写入操作，将字符串转为byte类型的数组写入文件中
	}catch(IOException e)
	{
		e.printStackTrace();
	}finally{
		try {
			fil.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
}
