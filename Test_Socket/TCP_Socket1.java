package Test_Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * �ͻ��������˷�����Ϣ��������յ����ڿ���̨�����Ȼ����ͻ��˻ظ���Ϣ
 * @author wushijia
 *
 */
public class TCP_Socket1 {
	@Test
	public void Client(){
		Socket socket = null;
		OutputStream os = null;
		InputStream in = null;
		try {
			socket = new Socket(InetAddress.getByName("localhost"),9090);
			os = socket.getOutputStream();
			os.write("���ǿͻ��ˣ�������յ���ظ�".getBytes());
			socket.shutdownOutput();
			//�������Է���˵���Ϣ
			in = socket.getInputStream();
			byte[] b = new byte[20];
			int len;
			while((len = in.read(b)) != -1){
				String str = new String(b,0,len);
				System.out.print(str);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(in != null){
				try {
					in.close();
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
	public void Server(){
		ServerSocket ss = null;
		Socket socket = null;
		InputStream in = null;
		OutputStream os = null;
		try {
			ss = new ServerSocket(9090);
			socket = ss.accept();
			in = socket.getInputStream();
			byte[] b = new byte[20];
			int len;
			while((len = in.read(b)) != -1){
				String str = new String(b,0,len);
				System.out.print(str);
			}
			//��ͻ��˷���Ϣ
			os = socket.getOutputStream();
			os.write("���Ƿ���ˣ������յ������Ϣ".getBytes());
			socket.shutdownOutput();
		} catch (IOException e) {
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
