package TestBufferedInputOutStream;
//缓冲流的使用(处理字节)
import java.io.*;

import org.junit.Test;

public class TestBuffered {
	@Test
	public void test(){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			//提供读入和写入的文件
			File file = new File("Hello.txt");//读入的文件必须存在
			File file1 = new File("Hello2.txt");
			//创建节点流
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(file1);
			//将创建好的节点流的对象作为形参传入到缓冲流的构造器中
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			//开始文件的复制
			byte[] b = new byte[128];//创建字节型数组b
			int len;
			while((len = bis.read(b)) != -1)
			{
				bos.write(b, 0, len);
				bos.flush();
			}
		}catch (IOException e) {

			e.printStackTrace();
		}finally{
		//复制完成后关闭文件
		try {
			if(bos != null)
			{
				bos.close();
			}
			if(bis != null)
			{
				bis.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
