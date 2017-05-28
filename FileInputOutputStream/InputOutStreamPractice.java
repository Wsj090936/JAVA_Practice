package FileInputOutputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

//ʹ���ֽ���ʵ�����ݵ���������
public class InputOutStreamPractice {
@Test
	public void test(){
	BufferedOutputStream bos = null;
	try {
		bos = new BufferedOutputStream(new FileOutputStream(new File("test.txt")));
		byte[] str = new String("����˧�磡��������"
				+ "�޵�~~").getBytes();
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
