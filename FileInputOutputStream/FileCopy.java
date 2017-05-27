package FileInputOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//文件的复制方法
public class FileCopy {
public void copyFile(String src,String dest){//src表示被复制的文件路径，dest表示复制出来的文件地址
	//1、创建读入和写入的文件
		File file1 = new File(src);
		File file2 = new File(dest);
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try{
			//2、提供流
		fis = new FileInputStream(file1);
		fos = new FileOutputStream(file2);
			//3、开始写入
		byte[] b = new byte[1024];//数组长度越大，在复制大文件时越快
		int len;
		while((len = fis.read(b)) != -1)
		{
			fos.write(b, 0, len);//从头开始写，写入长度为len个
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
