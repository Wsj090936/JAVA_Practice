package StandardInputOutStream;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//标准的输入输出流 System.in  System.out
//实现字符从小写转换成大写，输入“e”或“exit”退出
import org.junit.Test;

public class StadnardInOutStream {
@Test
	public void test(){
	BufferedReader br = null;
	try {
		InputStream ist = System.in;//System.in返回的是字节型的数据
		InputStreamReader isr = new InputStreamReader(ist);//转换为字符型
		 br = new BufferedReader(isr);
		String str;
		while(true)
		{
			System.out.println("请输入字符串");
			str = br.readLine();
			if(str.equalsIgnoreCase("e")||str.equalsIgnoreCase("exit"))
			{
				break;
			}
			String str1 = str.toUpperCase();//转换为大写
			System.out.println(str1);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(br != null)
		{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
}
