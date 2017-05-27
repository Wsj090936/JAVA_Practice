package TestBufferedInputOutStream;
//��������ʹ��(�����ֽ�)
import java.io.*;

import org.junit.Test;

public class TestBuffered {
	@Test
	public void test(){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			//�ṩ�����д����ļ�
			File file = new File("Hello.txt");//������ļ��������
			File file1 = new File("Hello2.txt");
			//�����ڵ���
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(file1);
			//�������õĽڵ����Ķ�����Ϊ�βδ��뵽�������Ĺ�������
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			//��ʼ�ļ��ĸ���
			byte[] b = new byte[128];//�����ֽ�������b
			int len;
			while((len = bis.read(b)) != -1)
			{
				bos.write(b, 0, len);
				bos.flush();
			}
		}catch (IOException e) {

			e.printStackTrace();
		}finally{
		//������ɺ�ر��ļ�
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
