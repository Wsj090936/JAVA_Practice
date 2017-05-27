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
	File file = new File("Hello1.txt");//����һ��File���͵��ļ���Ϊ��д��Ķ��󣬸��ļ����Բ����ڣ��������ڣ���ᴴ��һ�����ļ��������ڣ��Ḳ��ԭ���ļ�
	fil = new FileOutputStream(file);//����һ��FileOutputStream�Ķ���file��Ϊ�乹�������β�
	fil.write(new String("I am a handsome boy!").getBytes());//ִ��д����������ַ���תΪbyte���͵�����д���ļ���
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
