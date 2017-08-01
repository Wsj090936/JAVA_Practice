package Test_Socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
 * �ͻ��˷����ļ�������ˣ�����˽����ļ��������ڱ��أ�Ȼ����ͻ���һ������
 * @author wushijia
 *
 */
public class TCP_Socket2 {
	@Test
	public void client(){
		Socket socket = null;
		OutputStream os = null;

		FileInputStream fis = null;

		InputStream in = null;
		try {
			socket = new Socket(InetAddress.getByName("localhost"),9292);
			//�ӱ��ػ�ȡһ���ļ������͸������
			os = socket.getOutputStream();
			fis = new FileInputStream(new File("cat.png"));
			byte[] b = new byte[1024];
			int len = 0;
			while((len = fis.read(b)) != -1){
				os.write(b, 0, len);
			}
			socket.shutdownOutput();
			//���շ���˷�������Ϣ
			in = socket.getInputStream();
			byte[] b1 = new byte[20];
			int len1 = 0;
			while((len1 = in.read(b1)) != -1){
				String str = new String(b1,0,len1);
				System.out.println(str);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{//�ر�����
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis != null){
				
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(os != null){
				
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	@Test
	public void server(){
		ServerSocket ss = null;
		Socket socket = null;
		InputStream in = null;

		FileOutputStream fos = null;

		OutputStream os = null;
		try {
			ss = new ServerSocket(9292);
			socket = ss.accept();
			//����˱���ӿͻ��˷��͹������ļ�������
			in = socket.getInputStream();
			fos = new FileOutputStream(new File("TomCat.png"));
			byte[] b = new byte[1024];
			int len = 0;
			while((len = in.read(b)) != -1){
				fos.write(b, 0, len);
			}
			//��ͻ��˷���
			os = socket.getOutputStream();
			os.write("���Ѿ��յ��㷢���ļ�".getBytes());
			socket.shutdownOutput();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(os != null){
				
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(in != null){
				
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket != null){
				
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ss != null){
				
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
