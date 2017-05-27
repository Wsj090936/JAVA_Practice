package TestInputStreamReaderOutPutWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


import org.junit.Test;

//�ֽ������ַ���֮���ת��  InputStreamReader ���ֽ�ת��Ϊ�ַ�(����)  OutputStreamWriter���ַ�ת��Ϊ�ֽ�(����)-
public class TestOther {
@Test
	public void test(){
	BufferedReader br = null;
	BufferedWriter bw = null;
	try {
		File file = new File("Hello.txt");
		File file1 = new File("Hello6.txt");
		
		//����
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis, "GBK");//��GBK��ʽ����
		br = new BufferedReader(isr);
		
		//����
		FileOutputStream fos = new FileOutputStream(file1);
		OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");//��GBK��ʽ����
		bw = new BufferedWriter(osw);
		String str;
		while((str = br.readLine()) != null)
		{
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{//�ر��ļ�
	try {
		if(bw!=null)
		{
			bw.close();
		}
		if(br!=null)
		{
			br.close();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
}
