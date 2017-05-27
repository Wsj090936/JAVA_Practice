package FileInputOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//�ļ��ĸ��Ʒ���
public class FileCopy {
public void copyFile(String src,String dest){//src��ʾ�����Ƶ��ļ�·����dest��ʾ���Ƴ������ļ���ַ
	//1�����������д����ļ�
		File file1 = new File(src);
		File file2 = new File(dest);
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try{
			//2���ṩ��
		fis = new FileInputStream(file1);
		fos = new FileOutputStream(file2);
			//3����ʼд��
		byte[] b = new byte[1024];//���鳤��Խ���ڸ��ƴ��ļ�ʱԽ��
		int len;
		while((len = fis.read(b)) != -1)
		{
			fos.write(b, 0, len);//��ͷ��ʼд��д�볤��Ϊlen��
		}
		}catch(IOException e)
		{
			e.printStackTrace();
		}finally{
			try {
				if(fis!=null)
				{
					fis.close();
				}
				if(fos!=null)
				{
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
}
