package TestBufferedReaderWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

//ʹ���ַ���ʵ�����
public class ReaderWriterPractice {
@Test
	public void test(){
	BufferedWriter bw = null;
	try {
		bw = new BufferedWriter(new FileWriter(new File("test.txt")));
		bw.write("���  ����˧��");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		
	try {
		bw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
}
