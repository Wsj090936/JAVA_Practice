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

//字节流与字符流之间的转换  InputStreamReader 将字节转换为字符(解码)  OutputStreamWriter将字符转换为字节(解码)-
public class TestOther {
@Test
	public void test(){
	BufferedReader br = null;
	BufferedWriter bw = null;
	try {
		File file = new File("Hello.txt");
		File file1 = new File("Hello6.txt");
		
		//解码
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis, "GBK");//以GBK格式解码
		br = new BufferedReader(isr);
		
		//编码
		FileOutputStream fos = new FileOutputStream(file1);
		OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");//以GBK格式编码
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
	finally{//关闭文件
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
